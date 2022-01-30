package pl.kate.bookaro.uploads.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kate.bookaro.uploads.domain.Upload;

public interface UploadJpaRepository extends JpaRepository<Upload, Long> {
}
