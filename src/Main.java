public class Main {
    void main(){
        Character hero = new Character("Ragnar", 'W');
        Character enemy = new Character("Goblin", 'R');
        hero.inventory = new String[]{"Sword", "Shield", "Potion"};
        hero.gold = 156.50;
        System.out.println();
        hero.printCharacterSheet();
        enemy.printCharacterSheet();
        System.out.println("=== COMBAT ===");
        hero.attack(enemy);
        enemy.attack(hero);
        System.out.println();
        hero.heal(20);
        hero.addXP(1500);
        System.out.println();

        if (hero.removeGold(100.0)) {
            System.out.println("Bought a potion!");
        } else {
            System.out.println("Not enough gold!");
        }

        System.out.println("Health: " + hero.getHealthPercentage() + "%");

        if (hero.isHealthCritical()) {
            System.out.println("WARNING: Find a healer!");
        }

        System.out.println();
        hero.printCharacterSheet();
        enemy.printCharacterSheet();
    }
}