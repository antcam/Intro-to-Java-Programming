
/*(Game: scissor, rock, paper) Programming Exercise 3.17 gives a program that
plays the scissor-rock-paper game. Revise the program to let the user continuously
play until either the user or the computer wins more than two times than its
opponent.

 */

import java.util.Scanner;

public class _Programming_Exercises_5_34_Game_Scissor_Rock_Paper {
    public static void main(String[] args) {
        int computer = 0;
        int player = 0;

        do {

            Scanner input = new Scanner(System.in);

            System.out.print("scissor (0), rock (1), paper (2): ");
            int yourPick = input.nextInt();

            int computerPick = (int) (Math.random() * 3);

            System.out.print("The computer is ");

            switch (computerPick) {
                case 0:
                    System.out.print("scissor. ");
                    break;
                case 1:
                    System.out.print("rock. ");
                    break;
                case 2:
                    System.out.print("paper. ");
                    break;
            }

            System.out.print("You are ");

            switch (yourPick) {
                case 0:
                    System.out.print("scissor");
                    break;
                case 1:
                    System.out.print("rock");
                    break;
                case 2:
                    System.out.print("paper");
                    break;
                default:
                    System.out.print("selected wrong pick");
                    break;

            }

            System.out.print((yourPick == computerPick) ? " too. " : ". ");

            if (yourPick == computerPick) {
                System.out.println("It is as draw");
            } else if (yourPick == 0 && computerPick == 1) {
                System.out.println("You Lose");
                computer++;
            } else if (yourPick == 0 && computerPick == 2) {
                System.out.println("You Won");
                player++;
            } else if (yourPick == 1 && computerPick == 0) {
                System.out.println("You Lose");
                computer++;
            } else if (yourPick == 1 && computerPick == 2) {
                System.out.println("You Won");
                player++;
            } else if (yourPick == 2 && computerPick == 0) {
                System.out.println("You Lose");
                computer++;
            } else if (yourPick == 2 && computerPick == 1) {
                System.out.println("You Won");
                player++;
            } else {
                System.out.println("Error");
            }

            System.out.println("Computer: " + computer);
            System.out.println("Player " + player);

        } while ((computer != 2 || player != 0) && (computer != 0 || player != 2)
        && !(computer > 2 * player && player !=0) && !(player > 2 * computer && computer !=0));

        System.out.println("Game Results: ");
        System.out.println("Computer: " + computer);
        System.out.println("Player " + player);

        if (computer == 2 && player == 0) {
            System.out.println("The computer scores 2 and you 0, you lose");
        }

        if (computer == 0 && player == 2) {
            System.out.println("The computer scores 0 and you 2, you win");
        }

        if (computer > player && player !=0) {
            System.out.println("The computer is more than two times the score than yours, you lose");
        }

        if (computer < player && computer !=0) {
            System.out.println("The player is more than two times the score than computer, you won");
        }

    }

}

