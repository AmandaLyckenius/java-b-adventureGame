package se.amanda.adventure.rooms;

import se.amanda.adventure.GameLocations;

public class Bedroom {

    //Singleton används i varje rum-klass för att begränsa skapandet av instansen till en, och för smidig åtkomst av instansen

    private static Bedroom instance;
    private Bedroom(){}
    public static Bedroom getInstance(){
        if (instance==null){
            instance = new Bedroom();
        }
        return instance;
    }

    public void enterBedroom() {
        if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            GameLocations.setCurrentLocation(GameLocations.getBEDROOM());
            System.out.println("You are standing in the bedroom. Other from sleeping, there is not much to do here. \nEnter 'livingroom' to go back and explore more.");
        } else {
            System.out.println("You can't go in that direction from here.");
        }
    }

}
