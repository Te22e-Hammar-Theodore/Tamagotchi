import java.util.*;
public class Tamagotchi {
    //Datatypes
    public String name;
    private int hunger = 0;
    private int bordedom = 0;
    private boolean isAlive;
    private ArrayList<String> words = new ArrayList<>();
    private Random generator;

public Tamagotchi(String incomingName) {
    this.name = incomingName;
}
    public void feed() {
        hunger --;
    }

    public void speak() {

    bordedom--;
    }

    public void teach(String word) {
    words.add(word);
    }

    public void tick() {
    bordedom++;
    hunger ++;
    }

    public void printStats() {
        System.out.println(name);
    System.out.println(hunger);
        System.out.println(bordedom);
    }

    public boolean getAlive() {
        return isAlive;
    }

    private void reduceBordedom() {}
}
