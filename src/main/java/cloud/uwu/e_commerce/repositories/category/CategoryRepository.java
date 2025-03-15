package cloud.uwu.e_commerce.repositories.category;

import cloud.uwu.e_commerce.model.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
