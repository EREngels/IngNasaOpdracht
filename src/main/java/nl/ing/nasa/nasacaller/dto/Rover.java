package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

public class Rover {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private Date landing_date;
    @Getter @Setter private Date launch_date;
    @Getter @Setter private String status;
    @Getter @Setter private int max_sol;
    @Getter @Setter private Date max_date;
    @Getter @Setter private int total_photos;
    @Getter @Setter private ArrayList<RoverCamera> roverCameras;
}
