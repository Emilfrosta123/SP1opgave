public class Character {
    String name;
    int health;
    int maxHealth;
    int level;
    int xp;
    double gold;
    boolean alive;
    char characterClass;
    String[] inventory;

    public Character(String name, char characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.health = 100;
        this.maxHealth = 100;
        this.level = 1;
        this.xp = 0;
        this.gold = 0;
        this.alive = true;
        this.inventory = new String[0];
    }

    public void printCharacterSheet() {
        String className = "";
        if (characterClass == 'W') {
            className = "Warrior";
        } else if (characterClass == 'M') {
            className = "Mage";
        } else if (characterClass == 'R') {
            className = "Rogue";
        }

        System.out.println("=== CHARACTER SHEET ===");
        System.out.println("Name: " + name);
        System.out.println("Class: " + characterClass + " (" + className + ")");
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("XP: " + xp);
        System.out.println("Gold: " + gold);
        System.out.println("Alive: " + alive);
        System.out.println();
        printInventory();

        if (health < maxHealth * 0.25 && alive) {
            System.out.println("WARNING: Health critical!");
        }

        if (xp > 1000 * level) {
            System.out.println("Ready to level up!");
        }

        System.out.println();
    }

    public void takeDamage(int amount) {
        int oldHealth = health;
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " takes " + amount + " damage! Health: " + oldHealth + " -> " + health);
        if (health <= 0) {
            alive = false;
            System.out.println(name + " has died!");
        }
    }

    public void heal(int amount) {
        int oldHealth = health;
        health = health + amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " heals " + amount + " HP! Health: " + oldHealth + " -> " + health);
    }

    public void addGold(double amount) {
        gold = gold + amount;
        System.out.println(name + " receives " + amount + " gold!");
    }

    public boolean removeGold(double amount) {
        if (gold >= amount) {
            gold = gold - amount;
            return true;
        }
        return false;
    }

    public void addXP(int amount) {
        xp = xp + amount;
        System.out.println(name + " gains " + amount + " XP! Total: " + xp);
        if (xp > 1000 * level) {
            levelUp();
        }
    }

    public void levelUp() {
        level = level + 1;
        xp = 0;
        maxHealth = maxHealth + 10;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public boolean isHealthCritical() {
        return health < maxHealth * 0.25;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHealthPercentage() {
        return (double) health / maxHealth * 100;
    }

    public void printInventory() {
        System.out.println("Inventory (" + inventory.length + " items):");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("- " + inventory[i]);
        }
    }

    public void attack(Character target) {
        int damage = 0;
        if (characterClass == 'W') {
            damage = 15;
        } else if (characterClass == 'M') {
            damage = 18;
        } else if (characterClass == 'R') {
            damage = 12;
        }
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        target.takeDamage(damage);
    }
}