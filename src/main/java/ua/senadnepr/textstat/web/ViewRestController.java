package ua.senadnepr.textstat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.service.TextFileService;

import java.util.List;

@RestController
@RequestMapping(value = ViewRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewRestController {
    static final String REST_URL = "/rest";

    TextFileService service;

    @Autowired
    public ViewRestController(TextFileService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public List<TextFile> getTextFiles(){

        List<TextFile> textFiles = service.findAll();

        return textFiles;
    }

}
