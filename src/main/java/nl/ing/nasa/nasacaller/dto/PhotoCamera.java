package nl.ing.nasa.nasacaller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class PhotoCamera {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter @SerializedName("rover_id") private String roverId;
    @Getter @Setter @SerializedName("full_name") private String fullName;
}
