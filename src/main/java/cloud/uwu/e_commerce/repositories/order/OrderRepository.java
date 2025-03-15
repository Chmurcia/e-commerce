package cloud.uwu.e_commerce.repositories.order;

import cloud.uwu.e_commerce.model.order.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
}
