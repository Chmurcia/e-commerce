package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Return;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserReturnMapper {
    U_Return userReturnPostDTOToUserReturn(U_ReturnPostDTO uReturnPostDTO);

    U_ReturnResponseDTO userReturnToUserReturnResponseDTO(U_Return uReturn);
}
