package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productSettings.P_SettingsResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Settings;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSettingsMapper {
    P_SettingsResponseDTO productSettingsToProductSettingsResponseDTO(P_Settings pSettings);
}
