package cloud.uwu.e_commerce.mappers.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehousePostDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouse.WarehouseResponseDTO;
import cloud.uwu.e_commerce.model.warehouse.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseMapper {
    Warehouse warehousePostDTOToWarehouse(WarehousePostDTO warehousePostDTO);

    WarehouseResponseDTO warehouseToWarehouseResponseDTO(Warehouse warehouse);
}
