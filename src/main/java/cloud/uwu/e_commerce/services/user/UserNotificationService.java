package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationPostDTO;
import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserNotificationMapper;
import cloud.uwu.e_commerce.repositories.user.UserNotificationRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserNotificationService {
    private final UserRepository userRepository;
    private final UserNotificationRepository userNotificationRepository;
    private final UserNotificationMapper mapper;

    public Flux<U_NotificationResponseDTO> getUserNotificationsByUserId(String userId) {
        if (!StringUtils.hasText(userId)) {
            return Flux.error(new IllegalArgumentException("userId cannot be empty or null"));
        }

        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(userNotificationRepository.findByUserId(userId)
                        .map(mapper::userNotificationToUserNotificationResponseDTO));
    }

    public Mono<U_NotificationResponseDTO> getUserNotificationById(String id) {
        return userNotificationRepository.findById(id)
                .map(mapper::userNotificationToUserNotificationResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserNotification with id " + id + " not found")));
    }

    public Mono<U_NotificationResponseDTO> createUserNotification(U_NotificationPostDTO uNotification) {
        return userNotificationRepository
                .save(mapper.userNotificationPostDTOToUserNotification(uNotification))
                .map(mapper::userNotificationToUserNotificationResponseDTO);
    }

    public Mono<Void> deleteUserNotification(String id) {
        return userNotificationRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("UserNotification with id " + id + " not found")));
    }
}
