package nl.ing.nasa.web;

import nl.ing.nasa.nasacaller.NasaCaller;
import nl.ing.nasa.nasacaller.dto.NasaRoverResponse;
import nl.ing.nasa.web.dto.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ErrorControllerImpl implements ErrorController {

    @RequestMapping("/error")
    public String errorpage() {
        return "errorpage";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
