package nl.ing.nasa.nasacaller.dto;

import lombok.Getter;
import lombok.Setter;

public class PhotoCamera {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String roverId;
    @Getter @Setter private String fullName;
}
