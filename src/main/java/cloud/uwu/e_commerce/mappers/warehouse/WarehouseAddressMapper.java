package cloud.uwu.e_commerce.mappers.warehouse;

import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressPostDTO;
import cloud.uwu.e_commerce.dto.warehouse.warehouseAddress.W_AddressResponseDTO;
import cloud.uwu.e_commerce.model.warehouse.W_Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseAddressMapper {

    W_Address warehouseAddressPostDTOToWarehouseAddress(W_AddressPostDTO wAddressPostDTO);

    W_AddressResponseDTO warehouseAddressToWarehouseAddressResponseDTO(W_Address wAddress);
}
