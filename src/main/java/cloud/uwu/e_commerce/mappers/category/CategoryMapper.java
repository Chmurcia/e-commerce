package cloud.uwu.e_commerce.mappers.category;

import cloud.uwu.e_commerce.dto.category.CategoryPostDTO;
import cloud.uwu.e_commerce.dto.category.CategoryResponseDTO;
import cloud.uwu.e_commerce.model.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    Category categoryDTOToCategory(CategoryPostDTO categoryDTO);

    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
}
