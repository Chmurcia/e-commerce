package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productDiscount.P_DiscountPostDTO;
import cloud.uwu.e_commerce.dto.product.productDiscount.P_DiscountResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Discount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDiscountMapper {
    P_Discount productDiscountPostDTOToProductDiscount(P_DiscountPostDTO productDiscountPostDTO);

    P_DiscountResponseDTO productDiscountToProductDiscountResponseDTO(P_Discount pDiscount);
}
