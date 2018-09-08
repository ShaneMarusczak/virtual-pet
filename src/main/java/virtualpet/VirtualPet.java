package virtualpet;

import java.util.Random;

public class VirtualPet {
	public int hunger;
	public int thirst;
	private Random rand = new Random();
		
	
	public void tick() {
		int randomHunger = rand.nextInt(4) + 0;
		int randomThirst = rand.nextInt(4) + 0;
		hunger += randomHunger;
		thirst += randomThirst;
		isSick();
		needsToGo();
	}

	public boolean isHungry(int hunger) {
		if (hunger > 6) {
			return true;
		}
		return false;
	}

	public boolean isThirsty(int thirst) {
		if (thirst > 6) {
			return true;
		}
		return false;
	}

	public boolean isSick() {
		int randomNum = rand.nextInt(21) + 0;
		if (randomNum == 1) {
			return true;
		}
		return false;
	}
	
	public boolean needsToGo() {
		int randomNum = rand.nextInt(8) + 0;
		if (randomNum == 1) {
			return true;
		}
		return false;
	}
}
