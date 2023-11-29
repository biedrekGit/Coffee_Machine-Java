package machine;
import java.util.Scanner;
import java.util.Arrays;

public class CoffeeMachine {

    int hasWater = 400; // ml of water the coffee machine has
    int hasMilk = 540; // ml of milk the coffee machina has
    int hasBeans = 120; // grams of coffee beans the coffee machine has
    int hasCups = 9; // number of disposable cups the coffee machine has
    int hasMoney = 550; // money the coffee machine has; in $

    public void addWater(int water) {
        hasWater = hasWater + water;
    }
    public void addMilk(int milk) {
        hasMilk = hasMilk + milk;
    }
    public void addBeans(int beans) {
        hasBeans = hasBeans + beans;
    }
    public void addCups(int cups) {
        hasCups = hasCups + cups;
    }

    private void coffeeMachineSupplies() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water", hasWater);
        System.out.printf("\n%d ml of milk", hasMilk);
        System.out.printf("\n%d g of coffee beans", hasBeans);
        System.out.printf("\n%d disposable cups", hasCups);
        System.out.printf("\n$%d of money\n\n", hasMoney);
    }

    public void buyCoffee(String input) {
        switch (input) {
            case "1" -> buyEspresso();
            case "2" -> buyLatte();
            case "3" -> buyCappuccino();
            default -> System.out.println("ERROR : wrong input");
        }
    }

    public void buyEspresso() {
        int waterCups = hasWater / 250; // number of cups amount of water is sufficient for
        int beansCups = hasBeans / 16; // number of cups amount of beans is sufficient for
        int[] array = {waterCups, beansCups}; // checking how many cups are possible
        Arrays.sort(array);
        int cupsPossible = array[0];
        if (cupsPossible > 0) {
            System.out.println("I have enough resources, making you a coffee!\n");
            hasWater = hasWater - 250; // water left
            hasBeans = hasBeans - 16; // beans left
            hasMoney = hasMoney + 4; // money after transaction
            hasCups = hasCups - 1; // cups left
        } else {
            System.out.println("ERROR : not sufficient supplies\n");
        }
    }

    public void buyLatte() {
        int waterCups = hasWater / 350; // number of cups amount of water is sufficient for
        int milkCups = hasMilk / 75; // number of cups amount of milk is sufficient for
        int beansCups = hasBeans / 20; // number of cups amount of beans is sufficient for
        int[] array = {waterCups, milkCups, beansCups}; // checking how many cups are possible
        Arrays.sort(array);
        int cupsPossible = array[0];
        if (cupsPossible > 0) {
            System.out.println("I have enough resources, making you a coffee!\n");
            hasWater = hasWater - 350; // water left
            hasMilk = hasMilk - 75; // milk left
            hasBeans = hasBeans - 20; // beans left
            hasMoney = hasMoney + 7; // money after transaction
            hasCups = hasCups - 1; // cups left
        } else {
            System.out.println("ERROR : not sufficient supplies\n");
        }
    }

    public void buyCappuccino() {
        int waterCups = hasWater / 200; // number of cups amount of water is sufficient for
        int milkCups = hasMilk / 100; // number of cups amount of milk is sufficient for
        int beansCups = hasBeans / 12; // number of cups amount of beans is sufficient for
        int[] array = {waterCups, milkCups, beansCups}; // checking how many cups are possible
        Arrays.sort(array);
        int cupsPossible = array[0];
        if (cupsPossible > 0) {
            System.out.println("I have enough resources, making you a coffee!\n");
            hasWater = hasWater - 200; // water left
            hasMilk = hasMilk - 100; // milk left
            hasBeans = hasBeans - 12; // beans left
            hasMoney = hasMoney + 6; // money after transaction
            hasCups = hasCups - 1; // cups left
        } else {
            System.out.println("ERROR : not sufficient supplies\n");
        }
    }

    public void takeMoney() {
        System.out.printf("\nI gave you $%d\n\n", hasMoney);
        hasMoney = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        boolean runLoop = true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String actionInput = scanner.nextLine();
            switch (actionInput) {
                case "buy" -> {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String buyInput = scanner.nextLine();
                    if (buyInput.equals("back")) {
                        System.out.println();
                    } else {
                        machine.buyCoffee(buyInput);
                    }
                }
                case "fill" -> {
                    System.out.println();
                    System.out.println("Write how many ml of water you want to add:");
                    machine.addWater(scanner.nextInt());
                    System.out.println("Write how many ml of milk you want to add:");
                    machine.addMilk(scanner.nextInt());
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    machine.addBeans(scanner.nextInt());
                    System.out.println("Write how many disposable cups you want to add:");
                    machine.addCups(scanner.nextInt());
                    scanner.nextLine(); // resetting line
                    System.out.println();
                }
                case "take" -> machine.takeMoney();
                case "remaining" -> machine.coffeeMachineSupplies();
                case "exit" -> runLoop = false;
                default -> System.out.println("Try again.");
            }
        } while (runLoop);
    }
}
