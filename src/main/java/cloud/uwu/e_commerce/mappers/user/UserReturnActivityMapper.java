package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Return_Activity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserReturnActivityMapper {
    U_Return_Activity userReturnActivityPostDTOToUserReturnActivity(U_Return_ActivityPostDTO uReturnActivityPostDTO);

    U_Return_ActivityResponseDTO userReturnActivityToUserReturnActivityResponseDTO(U_Return_Activity uReturnActivity);
}
