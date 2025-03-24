package cloud.uwu.e_commerce.mappers.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouseInventory.W_InventoryResponseDTO;
import cloud.uwu.e_commerce.model.warehouse.W_Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseInventoryMapper {
    W_InventoryResponseDTO warehouseInventoryToWarehouseInventoryResponseDTO(W_Inventory wInventory);
}
