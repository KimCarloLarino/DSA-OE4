import java.util.Scanner;

public class OE4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("APPLICATION OF RECURSION");
            System.out.println();
            System.out.println("[1] Fibonacci series number");
            System.out.println("[2] Factorial of a number");
            System.out.println("[3] Reverse a number");
            System.out.println("[4] Reverse a word");
            System.out.println("[5] Tower of Hanoi");
            System.out.println("[0] Exit the program");
            System.out.println();
            System.out.print("Select your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter the number of terms in the Fibonacci series: ");
                    int n = input.nextInt();
                    System.out.println("The Fibonacci series: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(fibonacci(i) + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter a positive integer: ");
                    int num = input.nextInt();
                    System.out.println(num + "! = " + factorial(num));
                    break;
                case 3:
                    System.out.print("Enter a positive integer: ");
                    int num1 = input.nextInt();
                    System.out.println("The reverse of " + num1 + " is " + reverseNumber(num1));
                    break;
                case 4:
                    System.out.print("Enter a word: ");
                    String word = input.next();
                    System.out.println("The reverse of " + word + " is " + reverseWord(word));
                    break;
                case 5:
                    System.out.print("Enter the number of disks: ");
                    int disks = input.nextInt();
                    towerOfHanoi(disks, "A", "C", "B");
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);
        input.close();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int reverseNumber(int num) {
        if (num < 10) {
            return num;
        }
        int digit = num % 10;
        int numRemaining = num / 10;
        return digit * (int) Math.pow(10, String.valueOf(numRemaining).length()) + reverseNumber(numRemaining);
    }

    public static String reverseWord(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return reverseWord(word.substring(1)) + word.charAt(0);
    }

    public static void towerOfHanoi(int disks, String source, String target, String aux) {
    if (disks == 1) {
        System.out.println("Move disk 1 from " + source + " to " + target);
        return;
    }
    towerOfHanoi(disks - 1, source, aux, target);
    System.out.println("Move disk " + disks + " from " + source + " to " + target);
    towerOfHanoi(disks - 1, aux, target, source);
    }
}