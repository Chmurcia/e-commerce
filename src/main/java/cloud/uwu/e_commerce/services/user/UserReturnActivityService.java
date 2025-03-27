package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserReturnActivityMapper;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnActivityRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserReturnActivityService {
    private final UserRepository userRepository;
    private final UserReturnRepository userReturnRepository;
    private final UserReturnActivityRepository userReturnActivityRepository;
    private final UserReturnActivityMapper mapper;

    Flux<U_Return_ActivityResponseDTO> getUserReturnActivitiesByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .thenMany(userReturnActivityRepository.findByUserId(userId)
                        .map(mapper::userReturnActivityToUserReturnActivityResponseDTO));
    }

    Flux<U_Return_ActivityResponseDTO> getUserReturnActivitiesByReturnId(String returnId) {
        return userReturnRepository.findById(returnId)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturn with id " + returnId + " not found")))
                .thenMany(userReturnActivityRepository.findByReturnId(returnId)
                        .map(mapper::userReturnActivityToUserReturnActivityResponseDTO));
    }

    Mono<U_Return_ActivityResponseDTO> getUserReturnActivityById(String id) {
        return userReturnActivityRepository.findById(id)
                .map(mapper::userReturnActivityToUserReturnActivityResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturnActivity with id " + id + " not found")));
    }

    Mono<U_Return_ActivityResponseDTO> createUserReturnActivity(U_Return_ActivityPostDTO uReturnActivity) {
        return userReturnActivityRepository
                .save(mapper.userReturnActivityPostDTOToUserReturnActivity(uReturnActivity))
                .map(mapper::userReturnActivityToUserReturnActivityResponseDTO);
    }

    Mono<Void> deleteUserReturnActivity(String id) {
        return userReturnActivityRepository
                .deleteById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturnActivity with id " + id + " not found")));
    }
}
