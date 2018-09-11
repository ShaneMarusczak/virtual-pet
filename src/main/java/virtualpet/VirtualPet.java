package virtualpet;

import java.util.Random;

public class VirtualPet {
	private Random rand = new Random();
	private int hunger = rand.nextInt(10);
	private int thirst = rand.nextInt(10);
	private int energyLevel = rand.nextInt(5);
	private int tiredness = rand.nextInt(5);
	private int happiness = 5;
	private int runAway = 0;
	private int sick = 0;

	public int getRunAway() {
		return runAway;
	}

	public int getHunger() {
		return hunger;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getThirst() {
		return thirst;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public int getTiredness() {
		return tiredness;
	}

	public int getSick() {
		return sick;
	}

	public void tick() {
		int randomHunger = rand.nextInt(3) + 2;
		int randomThirst = rand.nextInt(3) + 2;
		hunger += randomHunger;
		thirst += randomThirst;
		tiredness += 1;
		if (tiredness < 4) {
			energyLevel += 2;
		}
	}

	public void increaseRunAway() {
		runAway += 1;
	}

	public void lowerRunAway() {
		runAway -= 1;
	}

	public boolean willRunAway() {
		if (runAway > 2) {
			return true;
		}
		return false;
	}

	public boolean isUnhappy(int happiness) {
		if (happiness < 2) {
			return true;
		}
		return false;
	}

	public boolean isTired(int tiredness) {
		if (tiredness > 10) {
			return true;
		}
		return false;
	}

	public void takeNap() {
		tiredness -= 20;
		hunger += 1;
		thirst += 1;
		energyLevel += 4;
		happiness += 5;
	}

	public boolean needsToPlay(int energyLevel) {
		if (energyLevel > 4) {
			return true;
		}
		return false;
	}

	public void playWith() {
		energyLevel -= 10;
		tiredness += 3;
		hunger += 1;
		thirst += 1;
		happiness += 5;
	}

	public boolean isHungry(int hunger) {
		if (hunger > 8) {
			happiness -= 1;
			return true;
		}
		return false;
	}

	public boolean isThirsty(int thirst) {
		if (thirst > 5) {
			happiness -= 1;
			tiredness += 1;
			return true;
		}
		return false;
	}

	public boolean isSick() {
		int randomNum = rand.nextInt(7);
		if (randomNum == 1) {
			happiness -= 6;
			tiredness += 3;
			sick = 1;
			return true;
		}
		if (randomNum == 2 || randomNum == 3 || randomNum == 4) {
			sick = 0;
			return false;
		}
		return false;
	}

	public void notSick() {
		sick = 0;
	}

	public boolean needsToGo() {
		int randomNum = rand.nextInt(6);
		if (randomNum == 1) {
			happiness -= 2;
			return true;
		}
		return false;
	}

	public boolean mightBite() {
		int randomNum = rand.nextInt(100);
		if (randomNum == 1) {
			happiness -= 7;
			return true;
		}
		return false;
	}

	public void giveDrink() {
		happiness += 8;
		thirst -= 21;
		tiredness += 2;
		hunger += 1;
	}

	public void giveFood() {
		happiness += 8;
		hunger -= 30;
		tiredness += 2;
		thirst += 2;
	}
}
