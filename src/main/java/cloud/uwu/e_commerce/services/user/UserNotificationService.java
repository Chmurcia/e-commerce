package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationPostDTO;
import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserNotificationMapper;
import cloud.uwu.e_commerce.model.user.U_Notification;
import cloud.uwu.e_commerce.repositories.user.UserNotificationRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserNotificationService {
    private final UserRepository userRepository;
    private final UserNotificationRepository userNotificationRepository;
    private final UserNotificationMapper mapper;

    private Mono<? extends U_Notification> returnMonoErrorAndLogWarn(String id) {
        log.warn("UserNotification with id {} not found", id);
        return Mono.error(new NotFoundException("UserNotification with id " + id + " not found"));
    }

    public Flux<U_NotificationResponseDTO> getUserNotificationsByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userNotificationRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userNotificationToUserNotificationResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserNotifications found for user with id {}", userId);

                    return Flux.empty();
                }));
    }

    public Mono<U_NotificationResponseDTO> getUserNotificationById(String id) {
        return userNotificationRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userNotificationToUserNotificationResponseDTO);

    }

    public Mono<U_NotificationResponseDTO> createUserNotification(U_NotificationPostDTO uNotification) {
        return userNotificationRepository
                .save(mapper.userNotificationPostDTOToUserNotification(uNotification))
                .map(mapper::userNotificationToUserNotificationResponseDTO);
    }

    public Mono<Void> deleteUserNotification(String id) {
        return userNotificationRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("UserNotification with id {} not found", id);
                    return Mono.error(new NotFoundException("UserNotification with id " + id + " not found"));
                }));
    }
}
