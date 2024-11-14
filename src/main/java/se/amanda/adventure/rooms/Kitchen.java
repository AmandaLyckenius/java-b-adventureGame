package se.amanda.adventure.rooms;

import se.amanda.adventure.GameLocations;
import se.amanda.adventure.Game;
import se.amanda.adventure.model.Resident;

import static se.amanda.adventure.Game.*;

public class Kitchen {
    private static Kitchen instance;
    private Kitchen(){}
    public static Kitchen getInstance(){
        if (instance== null){
            instance = new Kitchen();
        }
        return instance;
    }

    public void enterKitchen(Resident resident) {

        kitchenDescriptions();

        String userInput;
        while (Game.getInstance().isRunning()) {
            userInput = createScanner().toLowerCase();
            switch(userInput) {
                case "frying pan"-> {
                    Resident.setHasFryingPan(true);
                    resident.setDamage(resident.getDamage() + 3);
                    System.out.println("Good thinking. This could be used as a weapon.");
                    kitchenDescriptions();
                }
                case "pizza"-> {
                    Resident.setHasEatenPizza(true);
                    resident.setHealth(resident.getHealth() + 1);
                    System.out.println("The pizza tastes good and you feel like your energy has gone up significantly.");
                    kitchenDescriptions();
                }
                case "livingroom"-> {
                    Livingroom.getInstance().enterLivingroom();
                    return;
                }
                default-> System.out.println("Incorrect input");
            }
        }
    }

    public void kitchenDescriptions() {
        if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM()) && !Resident.getHasFryingPan() && !Resident.getHasEatenPizza()) {
            GameLocations.setCurrentLocation(GameLocations.getKITCHEN());
            System.out.println("You enter the kitchen.\nOne the kitchen island you notice a frying pan and some leftover pizza from last night.\nDo you want to take the frying pan or maybe eat some leftover pizza? Enter 'frying pan', 'pizza', or 'livingroom' to go back.");
        } else if ((GameLocations.getCurrentLocation().equals(GameLocations.getKITCHEN()) || (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM()))) && Resident.getHasFryingPan() && !Resident.getHasEatenPizza()) {
            System.out.println("There is still some leftover pizza on the kitchen island. \nEnter 'pizza' if you would like a snack or 'livingroom' to go back and explore more.");
        } else if((GameLocations.getCurrentLocation().equals(GameLocations.getKITCHEN()) || (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM()))) && Resident.getHasEatenPizza() && !Resident.getHasFryingPan()) {
            System.out.println("The frying pan is still on the kitchen island. Do you want to pick it up, or go back to the living room? Enter 'frying pan' or 'livingroom'");
        } else if ((GameLocations.getCurrentLocation().equals(GameLocations.getKITCHEN()) || (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) && Resident.getHasFryingPan() && Resident.getHasEatenPizza())) {
            GameLocations.setCurrentLocation(GameLocations.getKITCHEN());
            System.out.println("There is not much to do here in the kitchen. Enter 'livingroom' to go back and explore more.");
        } else {
            System.out.println("You can't go in that direction");
        }
    }


}
