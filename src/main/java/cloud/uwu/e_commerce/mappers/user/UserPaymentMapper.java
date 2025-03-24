package cloud.uwu.e_commerce.mappers.user;

import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentPostDTO;
import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentResponseDTO;
import cloud.uwu.e_commerce.model.user.U_Payment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserPaymentMapper {
    U_Payment userPaymentPostDTOToUserPayment(U_PaymentPostDTO uPaymentPostDTO);

    U_PaymentResponseDTO userPaymentToUserPaymentResponseDTO(U_Payment uPayment);
}
