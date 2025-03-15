package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Return_Activity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserReturnActivityRepository extends ReactiveMongoRepository<U_Return_Activity, String> {
}
