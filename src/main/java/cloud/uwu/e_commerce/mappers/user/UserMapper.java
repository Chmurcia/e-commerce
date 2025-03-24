package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.user.UserDTO;
import cloud.uwu.e_commerce.dto.user.user.UserResponseDTO;
import cloud.uwu.e_commerce.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User userPostDTOToUser(UserDTO userDTO);

    UserResponseDTO userToUserResponseDTO(User user);
}
