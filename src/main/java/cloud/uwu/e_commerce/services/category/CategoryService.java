package cloud.uwu.e_commerce.services.category;

import cloud.uwu.e_commerce.dto.category.CategoryPostDTO;
import cloud.uwu.e_commerce.dto.category.CategoryResponseDTO;
import cloud.uwu.e_commerce.exceptions.AlreadyExistsException;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.category.CategoryMapper;
import cloud.uwu.e_commerce.model.category.Category;
import cloud.uwu.e_commerce.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    private Mono<? extends Category> returnMonoErrorAndLogWarn(String id) {
        log.warn("Category with id {} not found", id);
        return Mono.error(new NotFoundException("Category with id " + id + " not found"));
    }

    Flux<CategoryResponseDTO> getAllCategories() {
        return repository.findAll()
                .map(mapper::categoryToCategoryResponseDTO);
    }

    Mono<CategoryResponseDTO> getCategoryById(String id) {
        return repository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::categoryToCategoryResponseDTO);
    }

    Mono<CategoryResponseDTO> getCategoryByName(String name) {
        return repository.findByName(name)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Category with name {} not found", name);
                    return Mono.error(new NotFoundException("Category with name " + name + " not found"));
                }))
                .map(mapper::categoryToCategoryResponseDTO);
    }

    Mono<CategoryResponseDTO> createCategory(CategoryPostDTO category) {
        return repository.findByName(category.getName())
                .flatMap(existingUser -> Mono.error(
                        new AlreadyExistsException("Category with name "
                                + category.getName()
                                + " already exists"))
                ).then(
                        repository.save(mapper.categoryDTOToCategory(category))
                                .map(mapper::categoryToCategoryResponseDTO)
                );
    }

    Mono<Void> deleteCategory(String id) {
        return repository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Category with id {} not found", id);
                    return Mono.error(new NotFoundException("Category with id " + id + " not found"));
                }));
    }
}
