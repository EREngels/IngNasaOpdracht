package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

public class PhotoCamera {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String rover_id;
    @Getter @Setter private String full_name;
}
