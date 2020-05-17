package nl.ing.nasa.nasacaller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Photo {

    @Getter @Setter private int id;
    @Getter @Setter private int sol;
    @Getter @Setter private PhotoCamera photoCamera;
    @Getter @Setter @SerializedName("img_src") private String imgSrc;
    @Getter @Setter @SerializedName("earth_date") private Date earthDate;
    @Getter @Setter private Rover rover;
}
