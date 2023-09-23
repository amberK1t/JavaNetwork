import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String [] choices = {"Камень", "Ножницы", "Бумага"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int computerChoice = random.nextInt(choices.length);

        System.out.println("Начало игры");
        System.out.println("0. Камень\n1. Ножницы\n2. Бумага\n");
        int playerChoice = scanner.nextInt();
        System.out.println(computerChoice);
        if (computerChoice == playerChoice) {
            System.out.println("Ничья");
        } else if (playerChoice == 0 && computerChoice == 1 || playerChoice == 1 && computerChoice == 2 || playerChoice == 2 && computerChoice == 0) {
            System.out.println("Победил игрок");
        } else {
            System.out.println("Победил компьютер");
        }


    }
}