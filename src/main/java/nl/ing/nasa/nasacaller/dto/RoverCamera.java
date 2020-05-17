package nl.ing.nasa.nasacaller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class RoverCamera {

    @Getter @Setter private String name;
    @Getter @Setter @SerializedName("full_name") private String fullName;
}
