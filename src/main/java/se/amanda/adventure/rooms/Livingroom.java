package se.amanda.adventure.rooms;

import se.amanda.adventure.GameLocations;


public class Livingroom {

    private static Livingroom instance;
    private Livingroom(){}
    public static Livingroom getInstance(){
        if (instance == null){
            instance = new Livingroom();
        }
        return instance;
    }

    public void enterLivingroom() {
        if (!GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            GameLocations.setCurrentLocation(GameLocations.getLIVINGROOM());
            System.out.println("You are now standing in the living room. Where to next? ");

        } else if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            System.out.println("You are already in the living room");
        } else {
            System.out.println("You can't go in that direction from here");
        }
    }

}
