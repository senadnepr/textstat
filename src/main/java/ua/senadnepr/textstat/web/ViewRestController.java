package ua.senadnepr.textstat.web;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
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

//    @GetMapping
//    public ModelAndView getTextFiles(ModelAndView modelAndView, RedirectAttributes attributes){
//
//        List<TextFile> textFiles = service.findAll();
//
// //       ModelAndView modelAndView = new ModelAndView("redirect:/test");
//        modelAndView.setViewName("redirect:/test");
//        modelAndView.addObject("textFiles", "adfsgdfagf");
//
//        //      modelAndView.addObject("textFiles", textFiles);
// //       attributes.addAttribute(textFiles);
//        return modelAndView;
//    }
}
