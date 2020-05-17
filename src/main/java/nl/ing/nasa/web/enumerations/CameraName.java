package nl.ing.nasa.web.enumerations;

public enum CameraName {

    FHAZ("Front Hazard Avoidance Camera"),
    RHAZ("Rear Hazard Avoidance Camera"),
    MAST("Mast Camera"),
    CHEMCAM("Chemistry and Camera Complex"),
    MAHLI("Mars Hand Lens Imager"),
    MARDI("Mars Descent Imager"),
    NAVCAM("Navigation Camera"),
    PANCAM("Panoramic Camera"),
    MINITES("Miniature Thermal Emission Spectrometer (Mini-TES)");

    private String name;

    CameraName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
