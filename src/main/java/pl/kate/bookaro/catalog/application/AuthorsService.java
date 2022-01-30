package pl.kate.bookaro.catalog.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kate.bookaro.catalog.application.port.AuthorsUseCase;
import pl.kate.bookaro.catalog.domain.Author;
import pl.kate.bookaro.catalog.db.AuthorJpaRepository;

import java.util.List;

@Service
@AllArgsConstructor
class AuthorsService implements AuthorsUseCase {
    private final AuthorJpaRepository repository;

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }
}
