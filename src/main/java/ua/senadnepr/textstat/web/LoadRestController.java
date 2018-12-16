package ua.senadnepr.textstat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.service.TextFileService;
import ua.senadnepr.textstat.util.ApplicationException;
import ua.senadnepr.textstat.util.MyFileUtils;

import java.util.List;

@RestController
@RequestMapping(value = LoadRestController.REST_URL)
public class LoadRestController {
    static final String REST_URL = "/rest";

    TextFileService service;

    Environment env;

    @Autowired
    public LoadRestController(TextFileService service, Environment env) {
        this.env = env;
        this.service = service;
    }

    @PostMapping("/add")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect: /load";
        }

        try {
            TextFile textFile = MyFileUtils.writeFile(file, env.getProperty("file.upload-dir"));
            service.save(textFile);
        } catch (ApplicationException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect: /load";
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        return "redirect:/load";
    }
}
