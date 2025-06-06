package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.user.UserDTO;
import cloud.uwu.e_commerce.dto.user.user.UserPatchDTO;
import cloud.uwu.e_commerce.dto.user.user.UserResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.exceptions.AlreadyExistsException;
import cloud.uwu.e_commerce.mappers.user.UserMapper;
import cloud.uwu.e_commerce.model.user.User;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    private Mono<? extends User> returnMonoErrorAndLogWarn(String id) {
        log.warn("User with id {} not found", id);
        return Mono.error(new NotFoundException("User with id " + id + " not found"));
    }

    public Mono<UserResponseDTO> getUserById(String id) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userToUserResponseDTO);

    }

    public Mono<UserResponseDTO> createUser(UserDTO user) {
        return repository.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.error(
                        new AlreadyExistsException("User with email "
                                + user.getEmail()
                                + " already exists"))
                ).then(
                        repository.save(mapper.userPostDTOToUser(user))
                                .map(mapper::userToUserResponseDTO)
                );
    }

    public Mono<UserResponseDTO> updateUser(String id, UserDTO user) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingUser -> repository.findByEmail(user.getEmail())
                        .filter(existingUserWithEmail -> !existingUserWithEmail.getId().equals(id))
                        .flatMap(existingUserWithEmail -> Mono.error(
                                new AlreadyExistsException("User with email "
                                        + user.getEmail()
                                        + " not found")))
                        .then(Mono.defer(() -> {
                            existingUser.setFirstName(user.getFirstName());
                            existingUser.setLastName(user.getLastName());
                            existingUser.setNickName(user.getNickName());
                            existingUser.setRole(user.getRole());
                            existingUser.setEmail(user.getEmail());

                            return repository.save(existingUser);
                        })))
                .map(mapper::userToUserResponseDTO);
    }

    public Mono<UserResponseDTO> patchUser(String id, UserPatchDTO user) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingUser -> {

                    Mono<User> emailCheck = (user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail()))
                            ? repository.findByEmail(user.getEmail())
                            .filter(existingUserWithEmail -> !existingUserWithEmail.getId().equals(id))
                            .flatMap(existingUserWithEmail -> Mono.error(
                                    new AlreadyExistsException("User with email "
                                            + existingUserWithEmail.getEmail()
                                            + " already exists")))
                            : Mono.empty();

                    return Mono.when(emailCheck)
                            .then(Mono.defer(() -> {
                                Optional.ofNullable(user.getFirstName())
                                        .ifPresent(existingUser::setFirstName);

                                Optional.ofNullable(user.getLastName())
                                        .ifPresent(existingUser::setLastName);

                                Optional.ofNullable(user.getNickName())
                                        .ifPresent(existingUser::setNickName);

                                Optional.ofNullable(user.getEmail())
                                        .ifPresent(existingUser::setEmail);

                                Optional.ofNullable(user.getRole())
                                        .ifPresent(existingUser::setRole);

                                return repository.save(existingUser);
                            }));
                })
                .map(mapper::userToUserResponseDTO);
    }

    public Mono<Void> deleteUser(String id) {
        return repository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("User with id {} not found", id);
                    return Mono.error(new NotFoundException("User with id " + id + " not found"));
                }));
    }
}
