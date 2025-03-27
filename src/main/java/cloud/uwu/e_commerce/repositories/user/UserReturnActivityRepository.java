package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Return_Activity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserReturnActivityRepository extends ReactiveMongoRepository<U_Return_Activity, String> {
    Flux<U_Return_Activity> findByUserId(String userId);

    Flux<U_Return_Activity> findByReturnId(String returnId);
}
