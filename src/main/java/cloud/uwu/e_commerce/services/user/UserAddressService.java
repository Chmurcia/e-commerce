package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPatchDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPostDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPutDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserAddressMapper;
import cloud.uwu.e_commerce.model.user.U_Address;
import cloud.uwu.e_commerce.repositories.user.UserAddressRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAddressService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final UserAddressMapper mapper;

    private Mono<? extends U_Address> returnMonoErrorAndLogWarn(String id) {
        log.warn("UserAddress with id {} not found", id);
        return Mono.error(new NotFoundException("UserAddress with id " + id + " not found"));
    }

    Flux<U_AddressResponseDTO> getUserAddressesByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userAddressRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userAddressToUserAddressResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserAddresses found for user with id {}", userId);

                    return Flux.empty();
                }));
    }

    Mono<U_AddressResponseDTO> getUserAddressById(String id) {
        return userAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userAddressToUserAddressResponseDTO);
    }

    Mono<U_AddressResponseDTO> createUserAddress(U_AddressPostDTO uAddress) {
        return userAddressRepository
                .save(mapper.userAddressPostDTOToUserAddress(uAddress))
                .map(mapper::userAddressToUserAddressResponseDTO);
    }

    Mono<U_AddressResponseDTO> updateUserAddress(String id, U_AddressPutDTO uAddress) {
        return userAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingAddress -> {

                    existingAddress.setCountry(uAddress.getCountry());
                    existingAddress.setState(uAddress.getState());
                    existingAddress.setCity(uAddress.getCity());
                    existingAddress.setStreet(uAddress.getStreet());
                    existingAddress.setZipCode(uAddress.getZipCode());

                    return userAddressRepository.save(existingAddress);
                })
                .map(mapper::userAddressToUserAddressResponseDTO);
    }

    Mono<U_AddressResponseDTO> patchUserAddress(String id, U_AddressPatchDTO uAddress) {
        return userAddressRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingAddress -> {

                    Optional.ofNullable(uAddress.getCountry())
                            .ifPresent(existingAddress::setCountry);

                    Optional.ofNullable(uAddress.getState())
                            .ifPresent(existingAddress::setState);

                    Optional.ofNullable(uAddress.getCity())
                            .ifPresent(existingAddress::setCity);

                    Optional.ofNullable(uAddress.getStreet())
                            .ifPresent(existingAddress::setStreet);

                    Optional.ofNullable(uAddress.getZipCode())
                            .ifPresent(existingAddress::setZipCode);

                    return userAddressRepository.save(existingAddress);
                })
                .map(mapper::userAddressToUserAddressResponseDTO);
    }

    Mono<Void> deleteUserAddress(String id) {
        return userAddressRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("UserAddress with id {} not found", id);
                    return Mono.error(new NotFoundException("UserAddress with id " + id + " not found"));
                }));
    }

}
