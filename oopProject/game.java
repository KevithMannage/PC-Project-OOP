import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Equipment {
	//all attributes are private
	//all attributes are read only once created
    private String name;
    private int price;
    private int attackModifier;
    private int defenceModifier;
    private int healthModifier;
    private int speedModifier;
    
    public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getAttackModifier() {
		return attackModifier;
	}
	public int getDefenceModifier() {
		return defenceModifier;
	}
	public int getHealthModifier() {
		return healthModifier;
	}
	public int getSpeedModifier() {
		return speedModifier;
	}

	public Equipment(String name, int price, int attackModifier, int defenceModifier, int healthModifier, int speedModifier) {
        this.name = name;
        this.price = price;
        this.attackModifier = attackModifier;
        this.defenceModifier = defenceModifier;
        this.healthModifier = healthModifier;
        this.speedModifier = speedModifier;
    }
}

abstract class Armour extends Equipment {
	// Armour has 0 attack modifier
    public Armour(String name, int price, int defenceModifier,int HealthModifier, int speedModifier) {
       super(name, price, 0, defenceModifier,HealthModifier, speedModifier);
    }
}

abstract class Artefact extends Equipment {
    public Artefact(String name, int price, int attackModifier, int defenceModifier, int healthModifier, int speedModifier) {
        super(name, price, attackModifier, defenceModifier, healthModifier, speedModifier);
    }
}


abstract class Archer extends Character {
    public  Archer(String name, int price, int attack, int defence, int health, int speed) {
        super(name,price,attack,defence,health,speed);
    }}
abstract class Knight extends Character{
    public  Knight(String name, int price, int attack, int defence, int health, int speed) {
        super(name,price,attack,defence,health,speed);
    }}
abstract class Mage extends Character{
    public  Mage (String name, int price, int attack, int defence, int health, int speed) {
        super(name,price,attack,defence,health,speed);
    }}
abstract class Healer extends Character{
    public  Healer(String name, int price, int attack, int defence, int health, int speed) {
        super(name,price,attack,defence,health,speed);
    }}
abstract class MythicalCreature extends Character {
    public  MythicalCreature(String name, int price, int attack, int defence, int health, int speed) {
        super(name,price,attack,defence,health,speed);
    }}

abstract class Character {
    private String name;
    private int price;
    private int attack;
    private int defence;
	private int health;
    private int speed;
    private Armour armour;
    private Artefact artifact;

    public Character(String name, int price, int attack, int defence, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public void equipArmour(Armour armour) {
        this.armour = armour;
        this.defence += armour.getDefenceModifier();
        this.speed += armour.getSpeedModifier();
        this.health += armour.getHealthModifier();
    }

    public void equipArtifact(Artefact artifact) {
        this.artifact = artifact;
        this.attack += artifact.getAttackModifier();
        this.defence += artifact.getDefenceModifier();
        this.health += artifact.getHealthModifier();
        this.speed += artifact.getSpeedModifier();
    }
    
    public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Armour getArmour() {
		return armour;
	}

	public Artefact getArtifact() {
		return artifact;
	}
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", attack=" + attack +
                ", defence=" + defence +
                ", health=" + health +
                ", speed=" + speed +
                ", armour=" + armour +
                ", artifact=" + artifact +
                '}';
    }
}

class Player {
	// name, goldCoins are read and write
	// username, userID are read only
    private String name;
	private String username;
    private int userID;
	private int goldCoins;
    private Map<String, Character> army;

    public Player(String name, String username, int userID) {
        this.name = name;
        this.username = username;
        this.userID = userID;
        this.goldCoins = 500;
        this.army = new HashMap<>();
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public int getUserID() {
		return userID;
	}
	public int getGoldCoins() {
		return goldCoins;
	}
    public void recieveGoldCoins(int coins) {
        this.goldCoins += coins;
    }
    public void spendGoldCoins(int coins) {
        this.goldCoins -= coins;
    }

    public void displayArmy() {
        System.out.println(name + "'s Army:");
        for (Character character : army.values()) {
            System.out.println(character);
        }
    }
}

// Archer sub classes
class Shooter extends Archer { public Shooter() { super("Shooter", 80, 11, 4, 6, 9); } }
class Ranger extends Archer { public Ranger() { super("Ranger", 115, 14, 5, 8, 10); } }
class Sunfire extends Archer { public Sunfire() { super("Sunfire", 160, 15, 5, 7, 14); } }
class Zing extends Archer { public Zing() { super("Zing", 200, 16, 9, 11, 14); } }
class Saggitarius extends Archer { public Saggitarius() { super("Saggitarius", 230, 18, 7, 12, 17); } }

//Knight sub classes
class Squire extends Knight { public Squire() { super("Squire", 85, 8, 9, 7, 8); } }
class Cavalier extends Knight { public Cavalier() { super("Cavalier", 110, 10, 12, 7, 10); } }
class Templar extends Knight { public Templar() { super("Templar", 155, 14, 16, 12, 12); } }
class Zoro extends Knight { public Zoro() { super("Zoro", 180, 17, 16, 13, 14); } }
class Swiftblade extends Knight { public Swiftblade() { super("Swiftblade", 250, 18, 20, 17, 13); } }

//Mage sub classes
class Warlock extends Mage { public Warlock() { super("Warlock", 100, 12, 7, 10, 12); } }
class Illusionist extends Mage { public Illusionist() { super("Illusionist", 120, 13, 8, 12, 4); } }
class Enchanter extends Mage { public Enchanter() { super("Enchanter", 160, 16, 10, 13, 16); } }
class Conjurer extends Mage { public Conjurer() { super("Conjurer", 195, 18, 15, 14, 12); } }
class Eldritch extends Mage { public Eldritch() { super("Eldritch", 270, 19, 17, 18, 14); } }

//Healer sub classes
class Soother extends Healer { public Soother() { super("Soother", 95, 10, 8, 9, 6); } }
class Medic extends Healer { public Medic() { super("Medic", 125, 12, 9, 10, 7); } }
class Alchemist extends Healer { public Alchemist() { super("Alchemist", 150, 13, 13, 13, 13); } }
class Saint extends Healer { public Saint() { super("Saint", 200, 16, 14, 17, 9); } }
class Lightbringer extends Healer { public Lightbringer() { super("Lightbringer", 260, 17, 15, 19, 12); } }

// MythicalCreature sub classes
class Dragon extends MythicalCreature { public Dragon() { super("Dragon", 120, 12, 14, 15, 8); } }
class Basilisk extends MythicalCreature { public Basilisk() { super("Basilisk", 165, 15, 11, 10, 12); } }
class Hydra extends MythicalCreature { public Hydra() { super("Hydra", 205, 12, 16, 15, 11); } }
class Phoenix extends MythicalCreature { public Phoenix() { super("Phoenix", 275, 17, 13, 17, 19); } }
class Pegasus extends MythicalCreature { public Pegasus() { super("Pegasus", 340, 14, 18, 20, 20); } }

//Armour sub classes
class Chainmail extends Armour { public Chainmail() { super("Chainmail", 70, 0, 1, -1); } }
class Regalia extends Armour { public Regalia() { super("Regalia", 105, 1, 0, 0); } }
class Fleece extends Armour { public Fleece() { super("Fleece", 150, 2, 1, -1); } }

//Artefact sub classes
class Amulet extends Artefact { public Amulet() { super("Amulet", 200, 1, -1, 1, 1); } }
class Excalibur extends Artefact { public Excalibur() { super("Excalibur", 150, 2, 0, 0, 0); } }
class Crystal extends Artefact { public Crystal() { super("Crystal", 210, 2, 1, -1, -1); } }

class MysticMayhemGame {
	public static void mainMenu() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1)Login");
	        System.out.println("2)Create a profile");
	        System.out.println("3)Exit");
	        System.out.println("\nPlease select a menu option");
	        break;
		}
	}
    public static void main(String[] args) {
        System.out.println("----------------\n| Mystic Mayhem |\n----------------\n");
        mainMenu();
    }
}