package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPatchDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPostDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPutDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserAddressMapper;
import cloud.uwu.e_commerce.repositories.user.UserAddressRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAddressService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final UserAddressMapper mapper;

    Flux<U_AddressResponseDTO> getUserAddressesByUserId(String userId) {
        if (!StringUtils.hasText(userId)) {
            return Flux.error(new IllegalArgumentException("userId cannot be empty or null"));
        }

        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(userAddressRepository.findByUserId(userId)
                        .map(mapper::userAddressToUserAddressResponseDTO));
    }

    Mono<U_AddressResponseDTO> getUserAddressById(String id) {
        return userAddressRepository.findById(id)
                .map(mapper::userAddressToUserAddressResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserAddress with id " + id + " not found")));
    }

    Mono<U_AddressResponseDTO> createUserAddress(U_AddressPostDTO uAddress) {
        return userAddressRepository
                .save(mapper.userAddressPostDTOToUserAddress(uAddress))
                .map(mapper::userAddressToUserAddressResponseDTO);
    }

    Mono<U_AddressResponseDTO> updateUserAddress(String id, U_AddressPutDTO uAddress) {
        return userAddressRepository.findById(id)
                .flatMap(existingAddress -> {

                    existingAddress.setCountry(uAddress.getCountry());
                    existingAddress.setState(uAddress.getState());
                    existingAddress.setCity(uAddress.getCity());
                    existingAddress.setStreet(uAddress.getStreet());
                    existingAddress.setZipCode(uAddress.getZipCode());

                    return userAddressRepository.save(existingAddress);
                })
                .map(mapper::userAddressToUserAddressResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserAddress with id " + id + " not found")));
    }

    Mono<U_AddressResponseDTO> patchUserAddress(String id, U_AddressPatchDTO uAddress) {
        return userAddressRepository.findById(id)
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
                .map(mapper::userAddressToUserAddressResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserAddress with id " + id + " not found")));
    }

    Mono<Void> deleteUserAddress(String id) {
        return userAddressRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("UserAddress with id " + id + " not found")));
    }

}
