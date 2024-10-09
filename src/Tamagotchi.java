import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tamagotchi {

    // Attributes
    public String name;
    private int hunger = 0;
    private int bordedom = 0;
    private int money = 100;
    private boolean isAlive;
    private final ArrayList<String> words = new ArrayList<>();
    private final Random generator = new Random();  // Initiera generator

    public Tamagotchi(String incomingName) {
        isAlive = true;
        words.add("Hallon!");

    }


    public void feed() {
        if (money >= 20) {
            System.out.println(name + " åt och blev mindre hungrig.");
            hunger -= generator.nextInt(1, 3);
            if (hunger < 0) {
                hunger = 0;
            }
            money -= 20;
        } else {
            System.out.println("Du har inte råd med detta!");
        }
    }

    public void speak() {
        if (money >= 30) {
            if (words.isEmpty()) {
                System.out.println(name + " kan inte säga något än.");
            } else {
                int wordNum = generator.nextInt(words.size());
                System.out.println(name + " säger: " + words.get(wordNum));
            }
            reduceBordedom();
            money -= 30;
        } else {
            System.out.println("Du har inte råd med detta!");
        }

    }

    public void teach(String word) {
        if (money >= 40) {
            System.out.println(name + " lärde sig: " + word);
            words.add(word);
            reduceBordedom();
            money -= 40;
        } else {
            System.out.println("Du har inte råd med detta!");
        }
    }

    public void tick() {
        bordedom += 1;
        hunger += 1;
        if (hunger > 10 || bordedom > 10) {
            System.out.println(name + "stendog, bättre lycka nästa gång!");
            isAlive = false;
        }
    }

    public void printStats() {
        System.out.println("Namn: " + name);
        System.out.println("Hunger: " + hunger);
        System.out.println("Uttråkad: " + bordedom);
        System.out.println("Pengar: " + money + "¥");
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

    public void gainMoney(Scanner scanner) {
        System.out.println("Välkommen till Paradise grandiosa!");
        System.out.println("Gissa en siffra mellan 1-5");
        int moneyAnswer = scanner.nextInt();
        scanner.nextLine();
        int guessNumberAnswer = generator.nextInt(1, 6);
        if (moneyAnswer == guessNumberAnswer) {
            System.out.println("Grattis du vann, här har du degen!!!");
            money += 50;
        } else {
            System.out.println("Du gissade tyvärr fel!");
        }
    }

}
