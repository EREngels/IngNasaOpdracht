package nl.ing.nasa.nasacaller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

public class Rover {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter @SerializedName("landing_date") private Date landingDate;
    @Getter @Setter @SerializedName("launch_date") private Date launchDate;
    @Getter @Setter private String status;
    @Getter @Setter @SerializedName("max_sol") private int maxSol;
    @Getter @Setter @SerializedName("max_date")private Date maxDate;
    @Getter @Setter @SerializedName("total_photos")private int totalPhotos;
    @Getter @Setter @SerializedName("rover_cameras")private ArrayList<RoverCamera> roverCameras;
}
