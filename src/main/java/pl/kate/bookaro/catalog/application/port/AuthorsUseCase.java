package pl.kate.bookaro.catalog.application.port;

import pl.kate.bookaro.catalog.domain.Author;

import java.util.List;

public interface AuthorsUseCase {
    List<Author> findAll();
}
