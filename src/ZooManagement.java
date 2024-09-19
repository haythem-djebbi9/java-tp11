import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooManagement {
    private int nbrCages;
    private String zooName;

    public ZooManagement() {
        this.nbrCages = 20;
        this.zooName = "my zoo";
    }

    public void inputZooDetails() {
        Scanner scanner = new Scanner(System.in);

        // Saisie du nom du zoo
        System.out.print("Entrez le nom du zoo : ");
        this.zooName = scanner.nextLine().trim();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Entrez le nombre de cages : ");
            try {
                this.nbrCages = scanner.nextInt();
                if (this.nbrCages <= 0) {
                    throw new IllegalArgumentException("Le nombre de cages doit être supérieur à zéro.");
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : veuillez entrer un nombre entier valide.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    public void displayZooDetails() {
        System.out.println(zooName + " comporte " + nbrCages + " cages.");
    }

    public static void main(String[] args) {
        ZooManagement zoo = new ZooManagement();

        zoo.inputZooDetails();

        zoo.displayZooDetails();
    }
}