package nl.ing.nasa.web;

import nl.ing.nasa.nasacaller.NasaCaller;
import nl.ing.nasa.nasacaller.dto.NasaRoverResponse;
import nl.ing.nasa.nasacaller.dto.Photo;
import nl.ing.nasa.web.dto.SearchParameters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class HtmlControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NasaCaller nasaCaller;

    @Autowired
    HtmlController htmlController;

    @Test
    void testHtmlControllerGet() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("ING Nasa Zoekpagina")));
    }


    @Test
    void testHtmlControllerPost() throws Exception {
        SearchParameters searchParameters = new SearchParameters();

        NasaRoverResponse nasaRoverResponse = new NasaRoverResponse();
        ArrayList<Photo> photos = new ArrayList<>();
        Photo photo = new Photo();
        photo.setImgSrc("http://test.nl");
        photos.add(photo);

        nasaRoverResponse.setPhotos(photos);
        htmlController.nasaCaller=nasaCaller;
        when(nasaCaller.doCall(eq(searchParameters))).thenReturn(nasaRoverResponse);
        this.mockMvc.perform(post("/", searchParameters)).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Resultaat")));
    }

}