import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors, or exit): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter rock, paper, scissors, or exit.");
                continue;
            }

            int computerChoiceIndex = random.nextInt(3);
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);
            determineWinner(userChoice, computerChoice);
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static void determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}
