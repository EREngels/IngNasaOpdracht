package nl.ing.nasa.nasacaller;

import nl.ing.nasa.nasacaller.dto.NasaRoverResponse;
import nl.ing.nasa.nasacaller.dto.Photo;
import nl.ing.nasa.persistence.CallPersistenceService;
import nl.ing.nasa.web.dto.SearchParameters;
import nl.ing.nasa.web.enumerations.CameraName;
import nl.ing.nasa.web.enumerations.Rover;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class NasaCallerTest {

    @Autowired
    NasaCaller nasaCaller;

    @MockBean
    CallPersistenceService callPersistenceService;

    @Test
    void doTest() throws IOException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setSol(1000);
        searchParameters.setCamera(CameraName.FHAZ);
        searchParameters.setRover(Rover.CURIOSITY);

       nasaCaller.callPersistenceService = callPersistenceService;

        NasaRoverResponse nasaRoverResponse = nasaCaller.doCall(searchParameters);

        assertTrue(nasaRoverResponse != null);
        assertTrue(nasaRoverResponse.getPhotos().size() == 2);

        for (Photo photo : nasaRoverResponse.getPhotos()) {
            assertEquals(photo.getSol(), searchParameters.getSol());
            assertEquals(photo.getRover().getName().toString().toLowerCase(), searchParameters.getRover().toString().toLowerCase());
        }
    }
}