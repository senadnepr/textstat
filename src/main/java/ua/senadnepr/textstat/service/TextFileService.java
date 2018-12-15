package ua.senadnepr.textstat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.senadnepr.textstat.data.TextFilesJpaRepository;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.util.ApplicationException;

import java.util.List;

@Service
public class TextFileService {

    TextFilesJpaRepository repository;

    @Autowired
    public TextFileService(TextFilesJpaRepository repository) {
        this.repository = repository;
    }

    public void save(TextFile textFile) throws ApplicationException {
        try {
            repository.save(textFile);
        }catch (Exception e){
            throw new ApplicationException("Error write statistic in database");
        }

    }

    public List<TextFile> findAll() throws ApplicationException {
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new ApplicationException("Error read statistic in database");
        }
    }
}
