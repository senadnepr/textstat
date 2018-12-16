package ua.senadnepr.textstat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.service.TextFileService;
import ua.senadnepr.textstat.util.ApplicationException;
import ua.senadnepr.textstat.util.MyFileUtils;

@RestController
@RequestMapping
public class LoadRestController {

    TextFileService service;

    Environment env;

    @Autowired
    public LoadRestController(TextFileService service, Environment env) {
        this.env = env;
        this.service = service;
    }

    @PostMapping(value = "/load")
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
                                         ModelAndView modelAndView) {

        modelAndView.setViewName("load");

        if (file.isEmpty()) {
            modelAndView.addObject("message", "Please select a file to upload");
            return modelAndView;
        }

        try {
            TextFile textFile = MyFileUtils.writeFile(file, env.getProperty("file.upload-dir"));
            service.save(textFile);
        } catch (ApplicationException e) {

            modelAndView.addObject("error", e.getMessage());

            return modelAndView;
        }

        modelAndView.addObject("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'"
        );
        return modelAndView;
    }
}
