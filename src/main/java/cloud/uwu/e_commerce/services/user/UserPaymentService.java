package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentPostDTO;
import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserPaymentMapper;
import cloud.uwu.e_commerce.model.user.U_Payment;
import cloud.uwu.e_commerce.repositories.user.UserPaymentRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPaymentService {
    private final UserRepository userRepository;
    private final UserPaymentRepository userPaymentRepository;
    private final UserPaymentMapper mapper;

    private Mono<? extends U_Payment> returnMonoErrorAndLogWarn(String id) {
        log.warn("UserPayment with id {} not found", id);
        return Mono.error(new NotFoundException("UserPayment with id " + id + " not found"));
    }

    public Flux<U_PaymentResponseDTO> getUserPaymentByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userPaymentRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userPaymentToUserPaymentResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserPayments found for user with id {}", userId);
                    return Flux.empty();
                }));
    }

    public Mono<U_PaymentResponseDTO> getUserPaymentById(String id) {
        return userPaymentRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userPaymentToUserPaymentResponseDTO);
    }

    public Mono<U_PaymentResponseDTO> createUserPayment(U_PaymentPostDTO uPayment) {
        return userPaymentRepository
                .save(mapper.userPaymentPostDTOToUserPayment(uPayment))
                .map(mapper::userPaymentToUserPaymentResponseDTO);
    }

    public Mono<Void> deleteUserPayment(String id) {
        return userPaymentRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("UserPayment with id {} not found", id);
                    return Mono.error(new NotFoundException("UserPayment with id " + id + " not found"));
                }));
    }
}
