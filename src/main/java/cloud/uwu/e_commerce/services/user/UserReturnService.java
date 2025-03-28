package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturn.U_ReturnResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserReturnMapper;
import cloud.uwu.e_commerce.model.user.U_Return;
import cloud.uwu.e_commerce.repositories.order.OrderRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserReturnService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final UserReturnRepository userReturnRepository;
    private final UserReturnMapper mapper;

    private Mono<? extends U_Return> returnMonoErrorAndLogWarn(String id) {
        log.warn("UserReturn with id {} not found", id);
        return Mono.error(new NotFoundException("UserReturn with id " + id + " not found"));
    }

    public Flux<U_ReturnResponseDTO> getUserReturnsByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userReturnRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userReturnToUserReturnResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserReturns found for user with id {}", userId);
                    return Flux.empty();
                }));
    }

    public Flux<U_ReturnResponseDTO> getUserReturnsByOrderId(String orderId) {
        return orderRepository.findById(orderId)
                .switchIfEmpty(Mono.error(new NotFoundException("Order with id " + orderId + " not found")))
                .flatMapMany(order -> userReturnRepository.findByOrderId(order.getId())
                        .mapNotNull(mapper::userReturnToUserReturnResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserReturns found for order with id {}", orderId);
                    return Flux.empty();
                }));
    }

    public Mono<U_ReturnResponseDTO> getUserReturnById(String id) {
        return userReturnRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userReturnToUserReturnResponseDTO);
    }

    public Mono<U_ReturnResponseDTO> createUserReturn(U_ReturnPostDTO uReturn) {
        return userReturnRepository
                .save(mapper.userReturnPostDTOToUserReturn(uReturn))
                .map(mapper::userReturnToUserReturnResponseDTO);
    }

    public Mono<Void> deleteUserReturn(String id) {
        return userReturnRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("UserReturn with id {} not found", id);
                    return Mono.error(new NotFoundException("UserReturn with id " + id + " not found"));
                }));
    }

}
