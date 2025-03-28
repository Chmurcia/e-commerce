package cloud.uwu.e_commerce.services.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressPatchDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressPostDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressPutDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.warehouse.WarehouseAddressMapper;
import cloud.uwu.e_commerce.model.warehouse.W_Address;
import cloud.uwu.e_commerce.repositories.warehouse.WarehouseAddressRepository;
import cloud.uwu.e_commerce.repositories.warehouse.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseAddressService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseAddressRepository warehouseAddressRepository;
    private final WarehouseAddressMapper mapper;

    private Mono<? extends W_Address> returnMonoErrorAndLogWarn(String id) {
        log.warn("WarehouseAddress with id {} not found", id);
        return Mono.error(new NotFoundException("WarehouseAddress with id " + id + " not found"));
    }

    public Flux<W_AddressResponseDTO> getWarehouseAddressesByWarehouseId(String warehouseId) {
        return warehouseRepository.findById(warehouseId)
                .switchIfEmpty(Mono.error(new NotFoundException("Warehouse with id " + warehouseId + " not found")))
                .flatMapMany(warehouse -> warehouseAddressRepository.findByWarehouseId(warehouse.getId())
                        .mapNotNull(mapper::warehouseAddressToWarehouseAddressResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No WarehouseAddresses found for warehouse with id {}", warehouseId);

                    return Flux.empty();
                }));
    }

    public Mono<W_AddressResponseDTO> getWarehouseAddressById(String id) {
        return warehouseAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::warehouseAddressToWarehouseAddressResponseDTO);
    }

    public Mono<W_AddressResponseDTO> createWarehouseAddress(W_AddressPostDTO wAddress) {
        return warehouseAddressRepository
                .save(mapper.warehouseAddressPostDTOToWarehouseAddress(wAddress))
                .map(mapper::warehouseAddressToWarehouseAddressResponseDTO);
    }

    public Mono<W_AddressResponseDTO> updateWarehouseAddress(String id, W_AddressPutDTO wAddress) {
        return warehouseAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingAddress -> {

                    existingAddress.setCountry(wAddress.getCountry());
                    existingAddress.setState(wAddress.getState());
                    existingAddress.setCity(wAddress.getCity());
                    existingAddress.setStreet(wAddress.getStreet());
                    existingAddress.setZipCode(wAddress.getZipCode());

                    return warehouseAddressRepository.save(existingAddress);
                })
                .map(mapper::warehouseAddressToWarehouseAddressResponseDTO);
    }

    public Mono<W_AddressResponseDTO> patchWarehouseAddress(String id, W_AddressPatchDTO wAddress) {
        return warehouseAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingAddress -> {

                    Optional.ofNullable(wAddress.getCountry())
                            .ifPresent(existingAddress::setCountry);

                    Optional.ofNullable(wAddress.getState())
                            .ifPresent(existingAddress::setState);

                    Optional.ofNullable(wAddress.getCity())
                            .ifPresent(existingAddress::setCity);

                    Optional.ofNullable(wAddress.getStreet())
                            .ifPresent(existingAddress::setStreet);

                    Optional.ofNullable(wAddress.getZipCode())
                            .ifPresent(existingAddress::setZipCode);

                    return warehouseAddressRepository.save(existingAddress);
                })
                .map(mapper::warehouseAddressToWarehouseAddressResponseDTO);
    }

    public Mono<Void> deleteWarehouseAddress(String id) {
        return warehouseAddressRepository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("WarehouseAddress with id {} not found", id);
                    return Mono.error(new NotFoundException("WarehouseAddress with id " + id + " not found"));
                }));
    }
}
