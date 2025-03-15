package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Return;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserReturnRepository extends ReactiveMongoRepository<U_Return, String> {
}
