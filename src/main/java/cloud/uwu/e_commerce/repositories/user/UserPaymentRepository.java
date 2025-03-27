package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserPaymentRepository extends ReactiveMongoRepository<U_Payment, String> {
    Flux<U_Payment> findByUserId(String userId);
}
