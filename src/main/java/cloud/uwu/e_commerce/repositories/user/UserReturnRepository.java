package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Return;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserReturnRepository extends ReactiveMongoRepository<U_Return, String> {
    Flux<U_Return> findByUserId(String userId);

    Flux<U_Return> findByOrderId(String orderId);
}
