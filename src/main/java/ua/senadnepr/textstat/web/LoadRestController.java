package ua.senadnepr.textstat.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = LoadRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoadRestController {
    static final String REST_URL = "/load";


}
