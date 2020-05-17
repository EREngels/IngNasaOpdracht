package nl.ing.nasa.persistence;

import nl.ing.nasa.persistence.dto.CallDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;

@Service
public class CallPersistenceService {

    @Autowired
    CallRepository callRepository;

    public void save(URL url, long timeStartCall, long timeEndCall) {
            CallDto callDto = new CallDto();
            callDto.setReponseTime(timeEndCall - timeStartCall);
            callDto.setDateCreated(new Date());
            callDto.setUrl(url.toString());
            callRepository.save(callDto);
    }
}
