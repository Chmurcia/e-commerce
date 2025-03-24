package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userRefund.U_RefundPostDTO;
import cloud.uwu.e_commerce.dto.user.userRefund.U_RefundResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Refund;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRefundMapper {
    U_Refund userRefundPostDTOToUserRefund(U_RefundPostDTO uRefundPostDTO);

    U_RefundResponseDTO userRefundToUserRefundResponseDTO(U_Refund uRefund);
}
