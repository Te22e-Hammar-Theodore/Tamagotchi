import java.util.ArrayList;
import java.util.Random;

public class Tamagotchi {

    // Attributes
    public String name;
    private int hunger = 0;
    private int bordedom = 0;
    private boolean isAlive;
    private final ArrayList<String> words = new ArrayList<>();
    private final Random generator = new Random();  // Initiera generator

    public Tamagotchi(String incomingName) {
        isAlive = true;
        words.add("Hallon!");
    }

    public void feed() {
        System.out.println(name + " åt och blev mindre hungrig.");
        hunger -= 2;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void speak() {
        if (words.isEmpty()) {
            System.out.println(name + " kan inte säga något än.");
        } else {
            int wordNum = generator.nextInt(words.size());
            System.out.println(name + " säger: " + words.get(wordNum));
        }
        reduceBordedom();
    }

    public void teach(String word) {
        System.out.println(name + " lärde sig: " + word);
        words.add(word);
        reduceBordedom();
    }

    public void tick() {
        bordedom++;
        hunger++;
        if (hunger > 10 || bordedom > 10) {
            isAlive = false;
        }
    }

    public void printStats() {
        System.out.println("Namn: " + name);
        System.out.println("Hunger: " + hunger);
        System.out.println("Uttråkad: " + bordedom);
    }

    public boolean getAlive() {
        return isAlive;
    }

    private void reduceBordedom() {
        System.out.println(name + " blev nu mindre uttråkad.");
        bordedom -= 2;
        if (bordedom < 0) {
            bordedom = 0;
        }
    }
}
