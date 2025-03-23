package cloud.uwu.e_commerce.mappers.order;

import cloud.uwu.e_commerce.dto.order.orderAddress.O_AddressPostDTO;
import cloud.uwu.e_commerce.dto.order.orderAddress.O_AddressResponseDTO;
import cloud.uwu.e_commerce.model.order.O_Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderAddressMapper {
    O_Address orderAddressPostDTOToOrderAddress(O_AddressPostDTO orderAddressPostDTO);

    O_AddressResponseDTO orderAddressToOrderAddressResponseDTO(O_Address orderAddress);
}
