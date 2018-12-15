package ua.senadnepr.textstat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.service.TextFileService;
import ua.senadnepr.textstat.util.ApplicationException;

import java.util.List;

@RestController
@RequestMapping(value = ViewRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewRestController {
    static final String REST_URL = "/view";

    TextFileService service;

    @Autowired
    public ViewRestController(TextFileService service) {
        this.service = service;
    }

    @GetMapping
    public String getTextFiles(Model model){

        try {
            List<TextFile> textFiles = service.findAll();
            model.addAttribute("textFiles", textFiles);
        } catch (ApplicationException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "view";
    }
}
