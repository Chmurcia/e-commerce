package cloud.uwu.e_commerce.mappers.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouseItem.W_ItemResponseDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouseItem.W_ItemPostDTO;
import cloud.uwu.e_commerce.model.wishlist.W_Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseItemMapper {
    W_Item warehouseItemPostDTOToWarehouseItem(W_ItemPostDTO wItemPostDTO);

    W_ItemResponseDTO warehouseItemToWarehouseItemResponseDTO(W_Item wItem);
}
