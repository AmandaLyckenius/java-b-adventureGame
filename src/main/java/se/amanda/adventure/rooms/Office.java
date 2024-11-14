package se.amanda.adventure.rooms;

import se.amanda.adventure.Game;
import se.amanda.adventure.GameLocations;
import se.amanda.adventure.model.Burglar;

public class Office {

    private static Office instance;
    private Office(){}
    public static Office getInstance(){
        if (instance==null){
            instance=new Office();
        }
        return instance;
    }

    public void enterOffice(Burglar burglar) {
        if (GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            GameLocations.setCurrentLocation(GameLocations.getOFFICE());
            System.out.println("You enter the office. On the table you see a telephone. \nDo you want to call for help? enter 'call' or 'livingroom' to go back.");
            officeOptions(burglar);
        } else if (!GameLocations.getCurrentLocation().equals(GameLocations.getLIVINGROOM())) {
            System.out.println("You can't go there from here.");
        }
    }

    private void officeOptions(Burglar burglar) {
        String userInput;
        while (Game.getInstance().isRunning()) {
            userInput  = Game.createScanner().toLowerCase();
            if (Game.getInstance().isRunning() && burglar.isConscious()) {
                switch (userInput){
                    case "call"-> {
                        System.out.println("Just as ju pick up the phone, the burglar finds you and hits you in the head with a book he took from your bookcase. \nSadly, this is enough for you to become unconscious. When you wake up, your entire house is empty.");
                        System.out.println("GAME OVER. Would you like to play again? Enter 'play again' or 'quit'");
                        return;
                    }
                    case "livingroom" -> Livingroom.getInstance().enterLivingroom();
                    default -> System.out.println("Incorrect input");
                }
            }
            else if (Game.getInstance().isRunning() && !burglar.isConscious()) {
                switch (userInput){
                    case "call" -> {
                        System.out.println("You make your call to the police and they show up after a few minutes. They arrest the burglar and you can finally go back to sleep.\nYOU WIN, well done!");
                        System.out.println("Would you like to play again? Enter 'play again' otherwise enter 'quit'");
                        return;
                    }
                    case "livingroom" -> Livingroom.getInstance().enterLivingroom();
                    default -> System.out.println("Incorrect input");

                }
            }
        }



    }


}
