package cloud.uwu.e_commerce.mappers.wishlist;

import cloud.uwu.e_commerce.dto.wishlist.wishlistItem.W_ItemResponseDTO;
import cloud.uwu.e_commerce.dto.wishlist.wishlistItem.W_ItemPostDTO;
import cloud.uwu.e_commerce.model.wishlist.W_Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishlistItemMapper {
    W_Item wishlistItemPostDTOToWishlistItem(W_ItemPostDTO wItemPostDTO);

    W_ItemResponseDTO wishlistItemToWishlistItemResponseDTO(W_Item wItem);
}
