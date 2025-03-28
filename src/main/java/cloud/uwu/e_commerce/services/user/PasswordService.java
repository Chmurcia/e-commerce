package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.exceptions.InvalidPasswordException;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Mono<Void> changePassword(String id, String oldPassword, String newPassword) {

        if (newPassword.length() < 8) {
            return Mono.error(new IllegalArgumentException("New password must be at least 8 characters long"));
        }

        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + id + " not found")))
                .flatMap(existingUser -> {
                    if (!passwordEncoder.matches(oldPassword, existingUser.getHashedPassword())) {
                        return Mono.error(new InvalidPasswordException("Old password is incorrect"));
                    }

                    if (passwordEncoder.matches(newPassword, existingUser.getHashedPassword())) {
                        return Mono.error(new IllegalArgumentException("New password cannot be the same as the old password"));
                    }

                    existingUser.setHashedPassword(passwordEncoder.encode(newPassword));
                    return repository.save(existingUser).then();
                });
    }
}
