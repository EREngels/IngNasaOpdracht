package nl.ing.nasa.nasacaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:nasacaller/nasaIng.properties")
public class PropertiesSource {

    @Value("${nasa.rovers.photos.url}")
    private String nasaRoverUrl;

    @Value("${nasa.api.key}")
    private String apiKey;

    public String getNasaRoverUrl() {
        return nasaRoverUrl;
    }

    public void setNasaRoverUrl(String nasaRoverUrl) {
        this.nasaRoverUrl = nasaRoverUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
