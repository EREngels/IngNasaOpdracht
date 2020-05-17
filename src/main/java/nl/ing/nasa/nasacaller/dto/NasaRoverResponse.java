package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class NasaRoverResponse {
    @Getter @Setter
    private ArrayList<Photo> photos;
}
