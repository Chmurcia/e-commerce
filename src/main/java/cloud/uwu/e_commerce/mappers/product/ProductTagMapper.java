package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productTag.P_TagPostDTO;
import cloud.uwu.e_commerce.dto.product.productTag.P_TagResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductTagMapper {
    P_Tag productTagPostDTOToProductTag(P_TagPostDTO pTagPostDTO);

    P_TagResponseDTO productTagToProductTagResponseDTO(P_Tag pTag);
}
