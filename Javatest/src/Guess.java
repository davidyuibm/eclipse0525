import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int number = (int) (Math.random() * 10);
        System.out.println("number="+number);
        int guess;
        
        do {
            System.out.print("�q�Ʀr�]0 ~ 9�^:");
            guess = userInput.nextInt();
            System.out.println("guess="+guess);
        } while(guess != number);
        
        System.out.println("�q���F...XD");
    }
}