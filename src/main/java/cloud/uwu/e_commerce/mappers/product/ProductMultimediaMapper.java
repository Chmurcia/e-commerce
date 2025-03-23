package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productMultimedia.P_MultimediaPostDTO;
import cloud.uwu.e_commerce.dto.product.productMultimedia.P_MultimediaResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Multimedia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMultimediaMapper {
    P_Multimedia productMultimediaPostDTOToProductMultimedia(P_MultimediaPostDTO productMultimediaPostDTO);

    P_MultimediaResponseDTO productMultimediaToProductMultimediaResponseDTO(P_Multimedia pMultimedia);
}
