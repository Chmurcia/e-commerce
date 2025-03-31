package cloud.uwu.e_commerce.repositories.category;

import cloud.uwu.e_commerce.model.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    Mono<Category> findByName(String name);
}
