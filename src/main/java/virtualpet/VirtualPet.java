package virtualpet;

import java.util.Random;

public class VirtualPet {
	private Random rand = new Random();
	public int hunger = rand.nextInt(7)+0;
	public int thirst = rand.nextInt(7)+0;
	public int energyLevel = rand.nextInt(7)+0;
	public int tiredness = rand.nextInt(7)+0;
	public int sick = 0;
	

	public void tick() {
		int randomHunger = rand.nextInt(4) + 0;
		int randomThirst = rand.nextInt(4) + 0;
		hunger += randomHunger;
		thirst += randomThirst;
		tiredness += 1;
		if (tiredness < 4) {
			energyLevel += 2;
		}
		isSick();
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
		energyLevel += 5;
	}

	public boolean needsToPlay(int energyLevel) {
		if (energyLevel > 7) {
			return true;
		}
		return false;
	}

	public void playWith() {
		energyLevel -= 6;
		tiredness += 3;
		hunger += 2;
		thirst += 2;
	}

	public boolean isHungry(int hunger) {
		if (hunger > 7) {
			return true;
		}
		return false;
	}

	public boolean isThirsty(int thirst) {
		if (thirst > 7) {
			return true;
		}
		return false;
	}

	public int isSick() {
		int randomNum = rand.nextInt(21) + 0;
		int randomNum2 = rand.nextInt(4) + 0;
		if (randomNum == 1) {
			sick = 1;
			return sick;
		}
		if (randomNum2 == 2) {
			sick = 0;
			return sick;
		}
		return sick;
	}

	public boolean needsToGo() {
		int randomNum = rand.nextInt(9) + 0;
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
		thirst -= 7;
		hunger += 1;
	}

	public void giveFood() {
		hunger -= 7;
		thirst += 2;
	}
}
