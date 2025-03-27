package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Notification;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserNotificationRepository extends ReactiveMongoRepository<U_Notification, String> {
    Flux<U_Notification> findByUserId(String userId);
}
