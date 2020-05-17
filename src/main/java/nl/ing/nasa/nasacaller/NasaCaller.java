package nl.ing.nasa.nasacaller;

import com.google.gson.Gson;
import nl.ing.nasa.nasacaller.dto.Photo;
import nl.ing.nasa.persistence.CallPersistenceService;
import nl.ing.nasa.nasacaller.dto.NasaRoverResponse;
import nl.ing.nasa.web.dto.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class NasaCaller {

    @Autowired
    CallPersistenceService callPersistenceService;

    @Autowired
    PropertiesSource propertiesSource;

    public NasaRoverResponse doCall(SearchParameters searchParameters) throws IOException {
        URL url = buildUrl(searchParameters);

        long timeStartCall = System.currentTimeMillis();
        HttpURLConnection con = getHttpURLConnection(url);
        String response = getResponse(con);
        long timeEndCall = System.currentTimeMillis();

        callPersistenceService.save(url, timeStartCall, timeEndCall);
        
        return new Gson().fromJson(response, NasaRoverResponse.class);

    }

    private String getResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        return con;
    }

    private URL buildUrl(SearchParameters searchParameters) throws MalformedURLException {
        StringBuilder urlStringBuilder = new StringBuilder().append(propertiesSource.getNasaRoverUrl());
        urlStringBuilder.append(searchParameters.getRover().getName().toLowerCase());
        String photos = "/photos";
        urlStringBuilder.append(photos);
        String questionmark = "?";
        urlStringBuilder.append(questionmark);
        String parameterSol = "sol=";
        urlStringBuilder.append(parameterSol);
        urlStringBuilder.append(searchParameters.getSol());
        String andSign = "&";
        urlStringBuilder.append(andSign);
        String parameterCamera = "camera=";
        urlStringBuilder.append(parameterCamera);
        urlStringBuilder.append(searchParameters.getCamera().toString().toLowerCase());
        urlStringBuilder.append(andSign);
        String parameterApiKey = "api_key=";
        urlStringBuilder.append(parameterApiKey);
        urlStringBuilder.append(propertiesSource.getApiKey());

        return new URL(urlStringBuilder.toString());
    }

}
