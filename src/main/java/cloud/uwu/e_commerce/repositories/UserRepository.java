package cloud.uwu.e_commerce.repositories;

import cloud.uwu.e_commerce.model.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
