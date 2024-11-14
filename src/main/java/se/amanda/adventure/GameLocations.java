package se.amanda.adventure;

public class GameLocations {

    private static final String BEDROOM = "bedroom";
    private static final String KITCHEN = "kitchen";
    private static final String HALLWAY = "hallway";
    private static final String OFFICE = "office";
    private static final String LIVINGROOM = "livingroom";
    private static final String START = "start";
    private static String currentLocation= START;

    public static String getBEDROOM() {
        return BEDROOM;
    }

    public static String getKITCHEN() {
        return KITCHEN;
    }

    public static String getHALLWAY() {
        return HALLWAY;
    }

    public static String getOFFICE() {
        return OFFICE;
    }

    public static String getLIVINGROOM() {
        return LIVINGROOM;
    }

    public static String getSTART() {
        return START;
    }

    public static String getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(String currentLocation) {
        GameLocations.currentLocation = currentLocation;
    }
}
