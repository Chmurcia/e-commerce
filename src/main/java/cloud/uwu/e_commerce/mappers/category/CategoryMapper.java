package cloud.uwu.e_commerce.mappers.category;

import cloud.uwu.e_commerce.dto.category.CategoryDTO;
import cloud.uwu.e_commerce.dto.category.CategoryResponseDTO;
import cloud.uwu.e_commerce.model.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
}
