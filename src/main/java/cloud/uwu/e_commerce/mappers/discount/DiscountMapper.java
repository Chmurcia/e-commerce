package cloud.uwu.e_commerce.mappers.discount;

import cloud.uwu.e_commerce.dto.discount.DiscountResponseDTO;
import cloud.uwu.e_commerce.model.discount.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiscountMapper {
    DiscountResponseDTO discountToDiscountResponseDTO(Discount discount);
}
