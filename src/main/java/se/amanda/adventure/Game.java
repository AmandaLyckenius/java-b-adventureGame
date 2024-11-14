package se.amanda.adventure;

import se.amanda.adventure.model.Burglar;
import se.amanda.adventure.model.Resident;
import se.amanda.adventure.rooms.*;

import java.util.Scanner;

public class Game {

    //Spelklassen hanterar input från spelaren och metoder som involverar själva spelandet (start, play again, quit game)
    private static Game instance;
    private static Scanner scanner;
    private boolean running;
    private Resident resident;
    private Burglar burglar;

    private Game(){
        this.resident = new Resident("", 12,3);
        this.burglar= new Burglar("Burglar", 12,5);
        this.running=true;
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public static String createScanner() {
        if (scanner==null){
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }

    public boolean isRunning() {
        return running;
    }

    private void printWelcomeMenu() {
        System.out.println("WELCOME TO ADVENTURE-GAME");
        System.out.println("Enter your name:");
        String playerName = createScanner();
        resident.setRole(playerName);

        System.out.println("Hello " + resident.getRole() +  ", you are playing a resident and are currently in your house. You have fallen asleep in the livingroom.\nSuddenly you wake up from a sound. It's in the middle of the night. \nSomeone has entered your house.");
        System.out.println("You can explore the following rooms: 'bedroom', 'kitchen', 'hallway', 'office' and 'livingroom'. \nEnter 'quit' to exit game.");
    }

    public void start() {
        printWelcomeMenu();
        Livingroom.getInstance().enterLivingroom();
        getUserInput();
    }

    public void getUserInput() {
        while (running) {
            String userInput = createScanner().toLowerCase();
            switch (userInput) {
                case "bedroom" -> Bedroom.getInstance().enterBedroom();
                case "kitchen" -> Kitchen.getInstance().enterKitchen(resident);
                case "hallway" -> Hallway.getInstance().enterHallway(burglar);
                case "office" -> Office.getInstance().enterOffice(burglar);
                case "livingroom" -> Livingroom.getInstance().enterLivingroom();
                case "punch" -> Hallway.getInstance().fightOneRound(resident, burglar);
                case "play again" -> playAgain();
                case "quit" -> quitGame();
                default -> System.out.println("incorrect input");
            }
        }
    }

    //Vid avslut erbjuds spelaren spela igen. Namnet på spelaren ligger kvar men övriga värden återställs
    private void playAgain() {
        GameLocations.setCurrentLocation(GameLocations.getSTART());
        Resident.setHasFryingPan(false);
        Resident.setHasEatenPizza(false);
        resident.setHealth(12);
        resident.setDamage(3);
        burglar.setHealth(12);
        Livingroom.getInstance().enterLivingroom();
    }

    private void quitGame(){
        System.out.println("Thank you for playing!");
        closeScanner();
        running=false;
    }

    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
