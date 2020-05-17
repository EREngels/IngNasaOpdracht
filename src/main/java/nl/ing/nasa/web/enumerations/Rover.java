package nl.ing.nasa.web.enumerations;

import java.util.ArrayList;
import java.util.Arrays;


public enum Rover {
    CURIOSITY("Curiosity"),
    OPPORTUNITY("Opportunity"),
    SPIRIT("Spirit");

    private String name;


    Rover(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
