package nl.ing.nasa.web;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
