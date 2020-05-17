package nl.ing.nasa.web.dto;

import lombok.Getter;
import lombok.Setter;
import nl.ing.nasa.web.enumerations.CameraName;
import nl.ing.nasa.web.enumerations.Rover;

public class SearchParameters {

    @Getter @Setter private int sol;
    @Getter @Setter private CameraName camera;
    @Getter @Setter private Rover rover;

}
