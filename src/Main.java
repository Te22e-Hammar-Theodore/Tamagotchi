import java.util.Scanner;

public class Main {

    boolean isPlaying = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tamagotchi tama = new Tamagotchi("");
        System.out.println("Välkommen till din Tamagotchi");
        System.out.println("Vad ska din Tamagotchi heta?");
        System.out.println();
        System.out.println("Vad heter din karaktär?");
        System.out.print(">>> ");
        tama.name = sc.nextLine();

        while (tama.getAlive()) {
            System.out.println();
            System.out.println("Vad vill du göra?");
            System.out.println("1. Mata " + tama.name);
            System.out.println("2. Prata med " + tama.name);
            System.out.println("3. Lära " + tama.name + " ett nytt ord");
            System.out.println("4. Visa " + tama.name + "s stats");
            System.out.println("5. Avsluta");
            int menuChoise = sc.nextInt();
            sc.nextLine();

            switch (menuChoise) {
                case 1:
                    tama.feed();
                    break;
                case 2:
                    tama.speak();
                    break;
                case 3:
                    System.out.println("Vilket ord vill du lära " + tama.name + "?");
                    String word = sc.nextLine();
                    tama.teach(word);
                    break;
                case 4:
                    tama.printStats();
                    break;
                case 5:
                    System.out.println("Tack för denna gång!");
                    return;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}