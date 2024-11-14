package se.amanda.adventure.model;

public class Resident extends Entity{

    private static boolean hasFryingPan;
    private static boolean hasEatenPizza;

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public static boolean getHasFryingPan() {
        return hasFryingPan;
    }

    public static void setHasFryingPan(boolean hasFryingPan) {
        Resident.hasFryingPan = hasFryingPan;
    }

    public static boolean getHasEatenPizza() {
        return hasEatenPizza;
    }

    public static void setHasEatenPizza(boolean hasEatenPizza) {
        Resident.hasEatenPizza = hasEatenPizza;
    }
}
