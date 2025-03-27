package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentPostDTO;
import cloud.uwu.e_commerce.dto.user.userPayment.U_PaymentResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserPaymentMapper;
import cloud.uwu.e_commerce.repositories.user.UserPaymentRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserPaymentService {
    private final UserRepository userRepository;
    private final UserPaymentRepository userPaymentRepository;
    private final UserPaymentMapper mapper;

    public Flux<U_PaymentResponseDTO> getUserPaymentByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(userPaymentRepository.findByUserId(userId)
                        .map(mapper::userPaymentToUserPaymentResponseDTO));
    }

    public Mono<U_PaymentResponseDTO> getUserPaymentById(String id) {
        return userPaymentRepository.findById(id)
                .map(mapper::userPaymentToUserPaymentResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserPayment with id " + id + " not found")));
    }

    public Mono<U_PaymentResponseDTO> createUserPayment(U_PaymentPostDTO uPayment) {
        return userPaymentRepository
                .save(mapper.userPaymentPostDTOToUserPayment(uPayment))
                .map(mapper::userPaymentToUserPaymentResponseDTO);
    }

    public Mono<Void> deleteUserPayment(String id) {
        return userPaymentRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("UserPayment with id " + id + " not found")));
    }
}
