package nl.ing.nasa.web;

import nl.ing.nasa.nasacaller.NasaCaller;
import nl.ing.nasa.nasacaller.dto.NasaRoverResponse;
import nl.ing.nasa.web.dto.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HtmlController {

    @Autowired
    NasaCaller nasaCaller;

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("searchParameters", new SearchParameters());
        return "searchform";
    }

    @PostMapping("/")
    public String submit(@ModelAttribute SearchParameters searchParameters, Model model) throws IOException {
        NasaRoverResponse nasaRoverResponse = nasaCaller.doCall(searchParameters);
        model.addAttribute("response", nasaRoverResponse);
        return "result";
    }

}
