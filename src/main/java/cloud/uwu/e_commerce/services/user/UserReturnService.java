package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserReturnMapper;
import cloud.uwu.e_commerce.repositories.order.OrderRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserReturnService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final UserReturnRepository userReturnRepository;
    private final UserReturnMapper mapper;

    Flux<U_ReturnResponseDTO> getUserReturnsByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(userReturnRepository.findByUserId(userId)
                        .map(mapper::userReturnToUserReturnResponseDTO));
    }

    Flux<U_ReturnResponseDTO> getUserReturnsByOrderId(String orderId) {
        return orderRepository.findById(orderId)
                .switchIfEmpty(Mono.error(new NotFoundException("Order with id " + orderId + " not found")))
                .thenMany(userReturnRepository.findByOrderId(orderId)
                        .map(mapper::userReturnToUserReturnResponseDTO));
    }

    Mono<U_ReturnResponseDTO> getUserReturnById(String id) {
        return userReturnRepository.findById(id)
                .map(mapper::userReturnToUserReturnResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturn with id " + id + " not found")));
    }

    Mono<U_ReturnResponseDTO> createUserReturn(U_ReturnPostDTO uReturn) {
        return userReturnRepository
                .save(mapper.userReturnPostDTOToUserReturn(uReturn))
                .map(mapper::userReturnToUserReturnResponseDTO);
    }

    Mono<Void> deleteUserReturn(String id) {
        return userReturnRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturn with id " + id + " not found")));
    }

}
