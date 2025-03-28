package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityPostDTO;
import cloud.uwu.e_commerce.dto.user.userReturnActivity.U_Return_ActivityResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.user.UserReturnActivityMapper;
import cloud.uwu.e_commerce.model.user.U_Return_Activity;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnActivityRepository;
import cloud.uwu.e_commerce.repositories.user.UserReturnRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserReturnActivityService {
    private final UserRepository userRepository;
    private final UserReturnRepository userReturnRepository;
    private final UserReturnActivityRepository userReturnActivityRepository;
    private final UserReturnActivityMapper mapper;

    private Mono<? extends U_Return_Activity> returnMonoErrorAndLogWarn(String id) {
        log.warn("WarehouseAddress with id {} not found", id);
        return Mono.error(new NotFoundException("WarehouseAddress with id " + id + " not found"));
    }

    public Flux<U_Return_ActivityResponseDTO> getUserReturnActivitiesByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User with id " + userId + " not found")))
                .flatMapMany(user -> userReturnActivityRepository.findByUserId(user.getId())
                        .mapNotNull(mapper::userReturnActivityToUserReturnActivityResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserReturnActivities found for user with id {}", userId);
                    return Flux.empty();
                }));
    }

    public Flux<U_Return_ActivityResponseDTO> getUserReturnActivitiesByReturnId(String returnId) {
        return userReturnRepository.findById(returnId)
                .switchIfEmpty(Mono.error(new NotFoundException("UserReturn with id " + returnId + " not found")))
                .flatMapMany(userReturn -> userReturnActivityRepository.findByReturnId(userReturn.getId())
                        .map(mapper::userReturnActivityToUserReturnActivityResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No UserReturnActivities found for UserReturn with id {}", returnId);
                    return Flux.empty();
                }));
    }

    public Mono<U_Return_ActivityResponseDTO> getUserReturnActivityById(String id) {
        return userReturnActivityRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::userReturnActivityToUserReturnActivityResponseDTO);
    }

    public Mono<U_Return_ActivityResponseDTO> createUserReturnActivity(U_Return_ActivityPostDTO uReturnActivity) {
        return userReturnActivityRepository
                .save(mapper.userReturnActivityPostDTOToUserReturnActivity(uReturnActivity))
                .map(mapper::userReturnActivityToUserReturnActivityResponseDTO);
    }

    public Mono<Void> deleteUserReturnActivity(String id) {
        return userReturnActivityRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("WarehouseAddress with id {} not found", id);
                    return Mono.error(new NotFoundException("WarehouseAddress with id " + id + " not found"));
                }));
    }
}
