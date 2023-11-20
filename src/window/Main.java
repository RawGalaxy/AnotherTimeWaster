package window;
import entities.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();
        mainCharacter hero = new mainCharacter(ran.nextInt(5, 16), "Joe");
        System.out.println("You have " + hero.getPower() + " power\n");

        battle battle = new battle();

        int rounds = 3; // Number of total rounds
        while (rounds > 0) {
            int numberOfGoblins = ran.nextInt(2, 6); // 3 to 5 goblins
            spawnAndFightGoblins(hero, battle, scanner, ran, numberOfGoblins);
            rounds--;
        }

        scanner.close();
    }

    private static void spawnAndFightGoblins(mainCharacter hero, battle battle, Scanner scanner, Random ran, int numberOfMonsters) {
    	List<monsters> monstersList = new ArrayList<>();
        for (int i = 0; i < numberOfMonsters; i++) {
            int monsterPower = (i == 0) ? ran.nextInt(1, hero.getPower() + 1) : ran.nextInt(Math.max(15, hero.getPower() - 10), hero.getPower() + 15);
            monsters monster;
            int monsterType = ran.nextInt(3); // Randomly select between 0, 1, and 2

            switch (monsterType) {
                case 0: 
                    monster = new goblin(monsterPower); 
                    break;
                case 1: 
                    monster = new Kobold(monsterPower); 
                    break;
                default: 
                    monster = new Orc(monsterPower);
            }

            monstersList.add(monster);
        }

        // Display goblin options
        System.out.println("Choose a monster to fight:");
        for (int i = 0; i < monstersList.size(); i++) {
            System.out.println((i + 1) + ": " + monstersList.get(i).getName() +  " with " + monstersList.get(i).getPower() + " power");
        }

        // Get user choice
        int choice = -1;
        while (choice < 1 || choice > monstersList.size()) {
            System.out.print("Enter your choice (1-" + monstersList.size() + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // Clear invalid input
            }
        }

        // Fight the chosen goblin
        monsters chosenMonster = monstersList.get(choice - 1);
        System.out.println("Fighting chosen monster with " + chosenMonster.getPower() + " power");
        battle.fight(hero, chosenMonster);
        System.out.println("You have " + hero.getPower() + " power\n");
    }
}
