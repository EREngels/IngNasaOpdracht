package nl.ing.nasa.persistence;

import nl.ing.nasa.persistence.dto.CallDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
class CallPersistenceServiceTest {

    public static final String HTTP_TEST_URL_TEST = "http://test.url.test";
    public static final int FAKE_RESPONSE_TIME = 12345;
    public static final int MAX_TIME_TEST = 1000;
    @Autowired
    CallPersistenceService callPersistenceService;

    @MockBean
    CallRepository callRepositoryMock;

    @Captor
    ArgumentCaptor<CallDto> captor;


    @Test
    public void testService() throws MalformedURLException {
        callPersistenceService.save(new URL("http://test.url.test"), 0, FAKE_RESPONSE_TIME);
        verify(callRepositoryMock).save(captor.capture());
        assertEquals(HTTP_TEST_URL_TEST, captor.getValue().getUrl());
        assertEquals(FAKE_RESPONSE_TIME, captor.getValue().getReponseTime());

        long dateCreatedFromCaptorMillis = captor.getValue().getDateCreated().getTime();
        long dateNowMillis = new Date().getTime();
        assertTrue(dateNowMillis - dateCreatedFromCaptorMillis < MAX_TIME_TEST);
    }


}