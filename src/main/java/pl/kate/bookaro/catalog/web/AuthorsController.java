package pl.kate.bookaro.catalog.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kate.bookaro.catalog.application.port.AuthorsUseCase;
import pl.kate.bookaro.catalog.domain.Author;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
class AuthorsController {
    private final AuthorsUseCase authors;

    @GetMapping
    public List<Author> findAll() {
        return authors.findAll();
    }
}
