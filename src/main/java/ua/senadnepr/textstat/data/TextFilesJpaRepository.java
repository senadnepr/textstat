package ua.senadnepr.textstat.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.senadnepr.textstat.model.TextFile;

@Repository
public interface TextFilesJpaRepository extends JpaRepository<TextFile, Long> {

}
