package cloud.uwu.e_commerce.mappers.order;

import cloud.uwu.e_commerce.dto.order.orderItem.O_ItemPostDTO;
import cloud.uwu.e_commerce.dto.order.orderItem.O_ItemResponseDTO;
import cloud.uwu.e_commerce.model.order.O_Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {
    O_Item orderItemPostDTOToOrderItem(O_ItemPostDTO orderItemPostDTO);

    O_ItemResponseDTO orderItemToOrderItemResponseDTO(O_Item orderItem);
}
