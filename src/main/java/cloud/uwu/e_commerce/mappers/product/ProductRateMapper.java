package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productRate.P_RatePostDTO;
import cloud.uwu.e_commerce.dto.product.productRate.P_RateResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Rate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRateMapper {
    P_Rate productRatePostDTOToProductRate(P_RatePostDTO pRatePostDTO);

    P_RateResponseDTO productRateToProductRateResponseDTO(P_Rate pRate);
}
