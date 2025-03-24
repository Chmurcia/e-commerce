package cloud.uwu.e_commerce.mappers.wishlist;

import cloud.uwu.e_commerce.dto.wishlist.wishlist.WishlistResponseDTO;
import cloud.uwu.e_commerce.model.wishlist.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishlistMapper {
    WishlistResponseDTO wishlistToWishlistResponseDTO(Wishlist wishlist);
}
