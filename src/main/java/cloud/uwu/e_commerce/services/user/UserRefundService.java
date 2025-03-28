package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userRefund.U_RefundPostDTO;
import cloud.uwu.e_commerce.dto.user.userRefund.U_RefundResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserRefundMapper;
import cloud.uwu.e_commerce.model.user.U_Refund;
import cloud.uwu.e_commerce.repositories.user.UserRefundRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRefundService {
    private final UserRepository userRepository;
    private final UserRefundRepository userRefundRepository;
    private final UserRefundMapper mapper;

    private Mono<? extends U_Refund> returnMonoErrorAndLogWarn(String id) {
        log.warn("UserRefund with id {} not found", id);
        return Mono.error(new NotFoundException("UserRefund with id " + id + " not found"));
    }

    Flux<U_RefundResponseDTO> getUserRefundsByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userRefundRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userRefundToUserRefundResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserRefunds found for user with id {}", userId);
                    return Flux.empty();
                }));
    }

    Mono<U_RefundResponseDTO> getUserRefundById(String id) {
        return userRefundRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userRefundToUserRefundResponseDTO);
    }

    Mono<U_RefundResponseDTO> createUserRefund(U_RefundPostDTO uRefund) {
        return userRefundRepository
                .save(mapper.userRefundPostDTOToUserRefund(uRefund))
                .map(mapper::userRefundToUserRefundResponseDTO);
    }

    Mono<Void> deleteUserRefund(String id) {
        return userRefundRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("UserRefund with id {} not found", id);
                    return Mono.error(new NotFoundException("UserRefund with id " + id + " not found"));
                }));
    }
}
