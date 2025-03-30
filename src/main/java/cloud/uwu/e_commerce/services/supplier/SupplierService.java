package cloud.uwu.e_commerce.services.supplier;

import cloud.uwu.e_commerce.dto.supplier.SupplierPatchDTO;
import cloud.uwu.e_commerce.dto.supplier.SupplierPostDTO;
import cloud.uwu.e_commerce.dto.supplier.SupplierPutDTO;
import cloud.uwu.e_commerce.dto.supplier.SupplierResponseDTO;
import cloud.uwu.e_commerce.exceptions.AlreadyExistsException;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.supplier.SupplierMapper;
import cloud.uwu.e_commerce.model.supplier.Supplier;
import cloud.uwu.e_commerce.repositories.supplier.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.rmi.AlreadyBoundException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    private Mono<? extends Supplier> returnMonoErrorAndLogWarn(String id) {
        log.warn("Supplier with id {} not found", id);
        return Mono.error(new NotFoundException("Supplier with id " + id + " not found"));
    }

    Flux<SupplierResponseDTO> getAllSuppliers() {
        return repository.findAll()
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No suppliers found");
                    return Flux.empty();
                }))
                .map(mapper::supplierToSupplierResponseDTO);
    }

    Mono<SupplierResponseDTO> getSupplierById(String id) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::supplierToSupplierResponseDTO);
    }

    Mono<SupplierResponseDTO> createSupplier(SupplierPostDTO supplier) {
        return repository.findByName(supplier.getName())
                .flatMap(existingSupplier -> Mono.error(
                                new AlreadyBoundException("Supplier with name "
                                        + supplier.getName()
                                        + " already exists"))
                ).then(
                        repository.save(mapper.supplierPostDTOToSupplier(supplier))
                                .map(mapper::supplierToSupplierResponseDTO)
                );
    }

    Mono<SupplierResponseDTO> updateSupplier(String id, SupplierPutDTO supplier) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingSupplier -> {
                    Mono<Supplier> nameCheck = repository.findByName(supplier.getName())
                            .filter(existingSupplierWithName -> !existingSupplierWithName.getId().equals(id))
                            .flatMap(existingSupplierWithName -> Mono.error(
                                    new AlreadyExistsException("Supplier with name "
                                            + existingSupplierWithName.getName()
                                            + " already exists")));

                    Mono<Supplier> emailCheck = repository.findByEmail(supplier.getEmail())
                            .filter(existingSupplierWithEmail -> !existingSupplierWithEmail.getId().equals(id))
                            .flatMap(existingSupplierWithEmail -> Mono.error(
                                    new AlreadyExistsException("Supplier with email "
                                            + existingSupplierWithEmail.getEmail()
                                            + " already exists")));

                    Mono<Supplier> phoneCheck = repository.findByPhoneNumber(supplier.getPhoneNumber())
                            .filter(existingSupplierWithPhoneNumber -> !existingSupplierWithPhoneNumber.getId().equals(id))
                            .flatMap(existingSupplierWithPhoneNumber -> Mono.error(
                                    new AlreadyExistsException("Supplier with phone number "
                                            + existingSupplierWithPhoneNumber.getPhoneNumber()
                                            + " already exists")));

                    return Mono.when(nameCheck, emailCheck, phoneCheck)
                            .then(Mono.defer(() -> {
                                existingSupplier.setName(supplier.getName());
                                existingSupplier.setEmail(supplier.getEmail());
                                existingSupplier.setPhoneNumber(supplier.getPhoneNumber());
                                existingSupplier.setOperatingCountries(supplier.getOperatingCountries());

                                return repository.save(existingSupplier);
                            }));
                }).map(mapper::supplierToSupplierResponseDTO);
    }

    Mono<SupplierResponseDTO> patchSupplier(String id, SupplierPatchDTO supplier) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingSupplier -> {
                    Mono<Supplier> nameCheck = (supplier.getName() != null && !supplier.getName().equals(existingSupplier.getName()))
                    ? repository.findByName(supplier.getName())
                            .filter(existingSupplierWithName -> !existingSupplierWithName.getId().equals(id))
                            .flatMap(existingSupplierWithName -> Mono.error(
                                    new AlreadyExistsException("Supplier with name "
                                            + existingSupplierWithName.getName()
                                            + " already exists")))
                            : Mono.empty();

                    Mono<Supplier> emailCheck = (supplier.getEmail() != null && !supplier.getEmail().equals(existingSupplier.getEmail()))
                            ? repository.findByEmail(supplier.getEmail())
                            .filter(existingSupplierWithEmail -> !existingSupplierWithEmail.getId().equals(id))
                            .flatMap(existingSupplierWithEmail -> Mono.error(
                                    new AlreadyExistsException("Supplier with email "
                                            + existingSupplierWithEmail.getEmail()
                                            + " already exists")))
                            : Mono.empty();

                    Mono<Supplier> phoneCheck = (supplier.getPhoneNumber() != null &&
                            !supplier.getPhoneNumber().equals(existingSupplier.getPhoneNumber()))
                            ? repository.findByPhoneNumber(supplier.getPhoneNumber())
                            .filter(existingSupplierWithPhoneNumber -> !existingSupplierWithPhoneNumber.getId().equals(id))
                            .flatMap(existingSupplierWithPhoneNumber -> Mono.error(
                                    new AlreadyExistsException("Supplier with phone number "
                                            + existingSupplierWithPhoneNumber.getPhoneNumber()
                                            + " already exists")))
                            : Mono.empty();

                    return Mono.when(nameCheck, emailCheck, phoneCheck)
                            .then(Mono.defer(() -> {
                                Optional.ofNullable(supplier.getName())
                                        .ifPresent(existingSupplier::setName);

                                Optional.ofNullable(supplier.getEmail())
                                        .ifPresent(existingSupplier::setEmail);

                                Optional.ofNullable(supplier.getPhoneNumber())
                                        .ifPresent(existingSupplier::setPhoneNumber);

                                Optional.ofNullable(supplier.getOperatingCountries())
                                        .ifPresent(existingSupplier::setOperatingCountries);

                                return repository.save(existingSupplier);
                            }));
                }).map(mapper::supplierToSupplierResponseDTO);
    }

    Mono<Void> deleteSupplier(String id) {
        return repository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Supplier with id {} not found");
                    return Mono.error(new NotFoundException("Supplier with id " + id + " not found"));
                }));
    }
}
