package cloud.uwu.e_commerce.mappers.supplier;

import cloud.uwu.e_commerce.dto.supplier.SupplierPostDTO;
import cloud.uwu.e_commerce.dto.supplier.SupplierResponseDTO;
import cloud.uwu.e_commerce.model.supplier.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplierMapper {
    Supplier supplierPostDTOToSupplier(SupplierPostDTO supplierPostDTO);

    SupplierResponseDTO supplierToSupplierResponseDTO(Supplier supplier);
}
