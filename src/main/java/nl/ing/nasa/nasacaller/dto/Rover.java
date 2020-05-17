package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

public class Rover {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private Date landingDate;
    @Getter @Setter private Date launchDate;
    @Getter @Setter private String status;
    @Getter @Setter private int maxSol;
    @Getter @Setter private Date maxDate;
    @Getter @Setter private int totalPhotos;
    @Getter @Setter private ArrayList<RoverCamera> roverCameras;
}
