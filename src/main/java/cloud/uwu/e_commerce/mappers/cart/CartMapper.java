package cloud.uwu.e_commerce.mappers.cart;

import cloud.uwu.e_commerce.dto.cart.cart.CartResponseDTO;
import cloud.uwu.e_commerce.model.cart.Cart;

public interface CartMapper {
    CartResponseDTO cartToCartResponseDTO(Cart cart);
}
