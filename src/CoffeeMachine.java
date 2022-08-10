package machine;

import java.util.Scanner;

class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);
    private int waterCount;
    private int milkCount;
    private int coffeeBeansCount;
    private int moneyCount;
    private int cupsCount;
    CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        waterCount = water;
        milkCount = milk;
        coffeeBeansCount = coffeeBeans;
        moneyCount = money;
        cupsCount = cups;
    }
    public void setWater(int value) {
        waterCount += value;
    }
    public void setMilk(int value) {
        milkCount += value;
    }
    public void setCoffeeBeans(int value) {
        coffeeBeansCount += value;
    }
    public void setCups(int cups) {
        cupsCount += cups;
    }
    public void work() {
        while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action){
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> remaining();
                case "exit" -> {
                    return;
                }
            }
        }
    }
    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        setWater(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        setMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setCoffeeBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        setCups(scanner.nextInt());
    }
    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String action = scanner.next();

        switch (action){
            case "1" -> {
                Recipe espresso = new Recipe(250,0,16,4);
                brewCoffee(espresso);
            }
            case "2" -> {
                Recipe latte = new Recipe(350,75,20,7);
                brewCoffee(latte);
            }
            case "3" -> {
                Recipe cappuccino = new Recipe(200,100,12,6);
                brewCoffee(cappuccino);
            }
            case "back" -> {
            }
        }
    }
    private void brewCoffee(Recipe recipe) {
        if (recipe.getWater() > waterCount) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (recipe.getMilk() > milkCount) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (recipe.getCoffeeBeans() > coffeeBeansCount) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        waterCount -= recipe.getWater();
        milkCount -= recipe.getMilk();
        coffeeBeansCount -= recipe.getCoffeeBeans();
        cupsCount -= 1;
        moneyCount += recipe.getPrice();
    }
    public void take() {
        System.out.println("I gave you $" + moneyCount);
        moneyCount = 0;
    }
    public void remaining () {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterCount + " ml of water");
        System.out.println(milkCount + " ml of milk");
        System.out.println(coffeeBeansCount + " g of coffee beans");
        System.out.println(cupsCount + " disposable cups");
        System.out.println("$" + moneyCount + " of money\n");
    }

}