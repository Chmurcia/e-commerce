package cloud.uwu.e_commerce.services.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehousePatchDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehousePostDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehousePutDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehouseResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.warehouse.WarehouseMapper;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.warehouse.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper mapper;

    Flux<WarehouseResponseDTO> getWarehousesByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(warehouseRepository.findByUserId(userId)
                        .map(mapper::warehouseToWarehouseResponseDTO));
    }

    Mono<WarehouseResponseDTO> getWarehouseById(String id) {
        return warehouseRepository.findById(id)
                .map(mapper::warehouseToWarehouseResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("Warehouse with id " + id + " not found")));
    }

    Mono<WarehouseResponseDTO> createWarehouse(WarehousePostDTO warehouse) {
        return warehouseRepository
                .save(mapper.warehousePostDTOToWarehouse(warehouse))
                .map(mapper::warehouseToWarehouseResponseDTO);
    }

    Mono<WarehouseResponseDTO> updateWarehouse(String id, WarehousePutDTO warehouse) {
        return warehouseRepository.findById(id)
                .flatMap(existingWarehouse -> {

                    existingWarehouse.setName(warehouse.getName());
                    existingWarehouse.setProducts(warehouse.getProducts());

                    return warehouseRepository.save(existingWarehouse);
                })
                .map(mapper::warehouseToWarehouseResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("Warehouse with id " + id + " not found")));
    }


    Mono<WarehouseResponseDTO> patchWarehouse(String id, WarehousePatchDTO warehouse) {
        return warehouseRepository.findById(id)
                .flatMap(existingWarehouse -> {

                    Optional.ofNullable(warehouse.getName())
                            .ifPresent(existingWarehouse::setName);

                    Optional.ofNullable(warehouse.getProducts())
                            .ifPresent(existingWarehouse::setProducts);

                    return warehouseRepository.save(existingWarehouse);
                })
                .map(mapper::warehouseToWarehouseResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("Warehouse with id " + id + " not found")));
    }

    Mono<Void> deleteWarehouse(String id) {
        return warehouseRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Warehouse with id " + id + " not found")));
    }
}
