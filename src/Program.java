import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int eggs = 0;
        int floors = 0;
        try {
            System.out.println("How many eggs?");
            eggs = scr.nextInt();
            System.out.println("How many windows?");
            floors = scr.nextInt();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        EggDrop drop = new EggDrop(eggs, floors);
        System.out.println("The answer is " + drop.getMinNumOfEggDrops());
    }
}
