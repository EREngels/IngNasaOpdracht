package nl.ing.nasa.web.enumerations;


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

    void setName(String name) {
        this.name = name;
    }


}
