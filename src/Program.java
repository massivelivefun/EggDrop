import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int eggs, floors;
        Scanner scr = new Scanner(System.in);

        System.out.println("How many eggs?");
        eggs = Integer.parseInt(scr.nextLine());

        System.out.println("How many windows?");
        floors = Integer.parseInt(scr.nextLine());

        EggDrop drop = new EggDrop(eggs, floors);
        System.out.println("The answer is " + drop.getMinNumOfEggDrops());
    }
}
