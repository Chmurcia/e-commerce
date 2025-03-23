package cloud.uwu.e_commerce.mappers.order;

import cloud.uwu.e_commerce.dto.order.order.OrderPostDTO;
import cloud.uwu.e_commerce.dto.order.order.OrderResponseDTO;
import cloud.uwu.e_commerce.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order orderPostDTOToOrder(OrderPostDTO orderPostDTO);

    OrderResponseDTO orderToOrderResponseDTO(Order order);
}
