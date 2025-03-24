package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressPostDTO;
import cloud.uwu.e_commerce.dto.user.userAddress.U_AddressResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserAddressMapper {
    U_Address userAddressPostDTOToUserAddress(U_AddressPostDTO uAddressPostDTO);

    U_AddressResponseDTO userAddressToUserAddressResponseDTO(U_Address uAddress);
}
