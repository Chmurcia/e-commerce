package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Refund;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRefundRepository extends ReactiveMongoRepository<U_Refund, String> {
}
