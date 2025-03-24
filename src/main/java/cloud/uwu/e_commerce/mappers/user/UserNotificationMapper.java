package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationPostDTO;
import cloud.uwu.e_commerce.dto.user.userNotification.U_NotificationResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Notification;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserNotificationMapper {
    U_Notification userNotificationPostDTOToUserNotification(U_NotificationPostDTO uNotificationPostDTO);

    U_NotificationResponseDTO userNotificationToUserNotificationResponseDTO(U_Notification uNotification);
}
