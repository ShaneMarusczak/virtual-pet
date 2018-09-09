package virtualpet;

import java.util.Random;

public class VirtualPet {
	public static int hunger;
	public int thirst;
	public int energyLevel;
	public int tiredness;
	private Random rand = new Random();

	public void tick() {
		int randomHunger = rand.nextInt(4) + 0;
		int randomThirst = rand.nextInt(4) + 0;
		hunger += randomHunger;
		thirst += randomThirst;
		tiredness += 1;
		energyLevel += 2;
	}

	public boolean isTired(int tiredness) {
		if (tiredness > 10) {
			return true;
		}
		return false;
	}

	public void takeNap() {
		tiredness = 0;
		hunger += 2;
		thirst += 2;
		energyLevel += 1;
	}

	public boolean needsToPlay(int energyLevel) {
		if (energyLevel > 6) {
			return true;
		}
		return false;
	}

	public void playWith() {
		energyLevel -= 4;
		tiredness += 1;
		hunger += 1;
		thirst += 2;
	}

	public boolean isHungry(int hunger) {
		if (hunger > 5) {
			return true;
		}
		return false;
	}

	public boolean isThirsty(int thirst) {
		if (thirst > 5) {
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
		int randomNum = rand.nextInt(7) + 0;
		if (randomNum == 1) {
			return true;
		}
		return false;
	}

	public boolean mightBite() {
		int randomNum = rand.nextInt(200) + 0;
		if (randomNum == 100) {
			return true;
		}
		return false;
	}

	public void giveDrink() {
		thirst -= 4;
		hunger += 1;
	}

	public void giveFood() {
		hunger -= 1;
		thirst += 1;
	}
}
