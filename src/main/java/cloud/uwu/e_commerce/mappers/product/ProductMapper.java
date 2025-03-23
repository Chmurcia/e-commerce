package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.product.ProductPostDTO;
import cloud.uwu.e_commerce.dto.product.product.ProductResponseDTO;
import cloud.uwu.e_commerce.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product productPostDTOToProduct(ProductPostDTO productPostDTO);

    ProductResponseDTO productToProductResponseDTO(Product product);
}
