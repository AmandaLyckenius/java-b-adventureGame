package se.amanda.adventure.rooms;

import se.amanda.adventure.GameLocations;
import se.amanda.adventure.model.Burglar;
import se.amanda.adventure.model.Entity;
import se.amanda.adventure.model.Resident;


public class Hallway {

    private static Hallway instance;
    private Hallway() {
    }
    public static Hallway getInstance() {
        if (instance== null) {
            instance = new Hallway();
        }
        return instance;
    }


    public void enterHallway(Burglar burglar) {
        if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM()) && burglar.isConscious()) {
            GameLocations.setCurrentLocation(GameLocations.getHALLWAY());
            System.out.println("When you enter the hallway, you see the reason for why you woke up.\nA person stands in the hallway with a mask on their face. It's a burglar!");
            System.out.println("Do you want to fight the burglar and defend your home, or turn back to the living room? enter 'punch' or 'livingroom'");
        } else if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM()) && !burglar.isConscious()) {
            GameLocations.setCurrentLocation(GameLocations.getHALLWAY());
            System.out.println("The burglar is still lying there unconscious. Not much more to do in the hallway right now. \nEnter 'livingroom' to go back.");
        } else if (!GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            System.out.println("You can't go there from where you are.");
        }
    }

    public void fightOneRound(Resident resident, Burglar burglar) {
        if (!GameLocations.getCurrentLocation().equals(GameLocations.getHALLWAY())) {
            System.out.println("Nothing to fight here.");
        }
        if (GameLocations.getCurrentLocation().equals(GameLocations.getHALLWAY())) {
            executePunch(resident, burglar);
            if (burglar.isConscious()) {
                executePunch(burglar, resident);
                System.out.println("Enter 'punch' to keep fighting or 'livingroom' to try to escape");
            }
            if (!resident.isConscious()) {
                System.out.println("Unfortunately you lost the fight. When you wake up your house is empty.");
                System.out.println("GAME OVER. Enter 'play again' if you would like another shot. Otherwise enter 'quit'.");
            } else if (!burglar.isConscious()) {
                System.out.println("You won the fight, the burglar is now unconscious. Enter 'livingroom' to go back and try to find a phone to call for help.");
            }
        }
    }

    private void executePunch(Entity attacker, Entity defender) {
        attacker.punch(defender);
        System.out.println(attacker.getRole() + " hits " + defender.getRole());
        if (defender.isConscious()) {
            System.out.println(defender.getRole() + " is still conscious. Health: " + defender.getHealth());
        } else {
            System.out.println(defender.getRole() + " is unconscious!");
        }
    }


}
