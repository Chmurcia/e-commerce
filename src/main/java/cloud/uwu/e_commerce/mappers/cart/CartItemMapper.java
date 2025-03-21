package cloud.uwu.e_commerce.mappers.cart;

import cloud.uwu.e_commerce.dto.cart.cartItem.C_ItemPostDTO;
import cloud.uwu.e_commerce.dto.cart.cartItem.C_ItemResponseDTO;
import cloud.uwu.e_commerce.model.cart.C_Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartItemMapper {
    C_Item CartItemPostDTOToCartItem(C_ItemPostDTO cartItemPostDTO);

    C_ItemResponseDTO CartItemToCartItemResponseDTO(C_Item cartItem);
}
