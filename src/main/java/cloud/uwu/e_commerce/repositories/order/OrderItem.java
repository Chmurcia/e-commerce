package cloud.uwu.e_commerce.repositories.order;

import cloud.uwu.e_commerce.model.order.O_Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderItem extends ReactiveMongoRepository<O_Item, String> {
}
