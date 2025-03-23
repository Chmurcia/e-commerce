package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productVariant.P_VariantPostDTO;
import cloud.uwu.e_commerce.dto.product.productVariant.P_VariantResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Variant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductVariantMapper {
    P_Variant productVariantPostDTOToProductVariant(P_VariantPostDTO pVariantPostDTO);

    P_VariantResponseDTO productVariantToProductVariantResponseDTO(P_Variant pVariant);
}
