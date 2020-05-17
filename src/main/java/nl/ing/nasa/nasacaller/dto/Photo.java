package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Photo {

    @Getter @Setter private int id;
    @Getter @Setter private int sol;
    @Getter @Setter private PhotoCamera photoCamera;
    @Getter @Setter private String img_src;
    @Getter @Setter private Date earth_date;
    @Getter @Setter private Rover rover;
}
