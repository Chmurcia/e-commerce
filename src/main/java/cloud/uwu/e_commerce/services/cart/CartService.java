package cloud.uwu.e_commerce.services.cart;

import cloud.uwu.e_commerce.repositories.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
}
