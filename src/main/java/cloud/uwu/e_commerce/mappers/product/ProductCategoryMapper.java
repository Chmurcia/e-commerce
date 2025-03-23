package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productCategory.P_CategoryPostDTO;
import cloud.uwu.e_commerce.dto.product.productCategory.P_CategoryResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryMapper {
    P_Category productCategoryPostDTOToProductCategory(P_CategoryPostDTO pCategoryPostDTO);

    P_CategoryResponseDTO productCategoryToProductCategoryResponseDTO(P_Category pCategory);
}
