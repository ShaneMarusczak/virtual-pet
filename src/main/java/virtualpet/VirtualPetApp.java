package virtualpet;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApp {
	static VirtualPet myPet = new VirtualPet();
	static Scanner input = new Scanner(System.in);;

	public static void main(String[] args) {
		int menuInput;
		String ready;
		int inputCounter = 0;
		int runAwayCounter = 0;
		System.out.println("Welcome!");
		do {
			System.out.println("Are you ready to take care of very own Virtual Pet? (y/n)");
			ready = input.nextLine();
			if (!ready.equals("y")) {
				System.out.println("This is a big resonsibility!");
			}
		} while (!ready.equals("y"));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		myPet.tick();
		myPet.tick();
		boolean playingGame = true;
		System.out.println("What would you like to name your pet?");
		String name = input.nextLine();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		while (playingGame) {
			do {
				System.out.println("What would you like to do with " + name + "?");
				System.out.println("Enter 1 to feed " + name + ".");
				System.out.println("Enter 2 to give " + name + " a drink.");
				System.out.println("Enter 3 to play with " + name + ".");
				System.out.println("Enter 4 to let " + name + " take a nap.");
				System.out.println("Enter 5 to quit.");
				menuInput = input.nextInt();
				input.nextLine();
				inputCounter += 1;

			} while (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5);

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			if (menuInput == 1) {
				// giving food
				if (!myPet.isHungry(myPet.hunger)) {
					System.out.println(name + " is not hungry.");
					System.out.println("");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				} else {
					myPet.giveFood();
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						System.out.println(name + " ate everything you gave!");
						System.out.println("");

					}
				}
			}
			if (menuInput == 2) {
				if (!myPet.isThirsty(myPet.thirst)) {
					System.out.println(name + " is not thirst.");
					System.out.println("");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				} else {
					myPet.giveFood();
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						System.out.println(name + " drank the whole bowl!");
						System.out.println("");

					}

				}
			}
			if (menuInput == 3) {
				// playing
				if (!myPet.needsToPlay(myPet.energyLevel)) {
					System.out.println(name + " does not want to play.");
					System.out.println("");
				} else {
					myPet.playWith();
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						System.out.println(name + " had so much fun playing!");
						System.out.println("");

					}
				}
			}
			if (menuInput == 4) {
				// nap
				if (!myPet.isTired(myPet.tiredness)) {
					System.out.println(name + " is not sleepy.");
					System.out.println("");
				} else {
					myPet.playWith();
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						System.out.println(name + " had a great nap!");
						System.out.println("");

					}
				}
			}
			if (menuInput == 5) {
				System.out.println("Are you sure you want to quit and leave your pet all alone?(y/n)");
				String willExit = input.nextLine();
				if (willExit.equals("y")) {
					System.out.println(name + " will miss you!.");
					playingGame = false;
				} else {
					System.out.println("Good! " + name + " will be happy you stayed!");
				}

			}
			if (inputCounter == 2) {
				myPet.tick();
				if (myPet.mightBite()) {
					System.out.println(name + " just bit you!");
				} else if (myPet.isSick()) {
					System.out.println(name + " is sick.");
					System.out.println("Take " + name + " to the vet?(y/n)");
					String takeToVet = input.nextLine();
					if (takeToVet.equals("y")) {
						System.out.println(name + " made a full recovery!");
					} else {
						System.out.println(name + " is very ill, he might get worse.");
					}
				} else if (myPet.needsToGo()) {
					System.out.println(name + " needs to go outside.");
					System.out.println("Let " + name + " out?(y/n)");
					String letOut = input.nextLine();
					if (letOut.equals("y")) {
						System.out.println(name + " feels much better!");
					} else {
						System.out.println(name + " had an accident. Better clean it up.");
					}

				}
				inputCounter -= 2;
			}

			if (myPet.isTired(myPet.tiredness)) {
				System.out.println(name + " is getting tired.");
				if (myPet.tiredness > 12) {
					System.out.println("VERY TIRED!");
				}
			}
			if (myPet.isHungry(myPet.hunger)) {
				System.out.println(name + " is getting hungry.");
				if (myPet.hunger > 12) {
					System.out.println("VERY HUNGRY!");
				}
			}
			if (myPet.isThirsty(myPet.thirst)) {
				System.out.println(name + " is getting thirsty.");
				if (myPet.thirst > 12) {
					System.out.println("VERY THIRSTY!");
				}
			}
			if (myPet.needsToPlay(myPet.energyLevel)) {
				System.out.println(name + " would like to play!");
				if (myPet.energyLevel > 12) {
					System.out.println("PLAY WITH ME NOW!");
				}
			}
			if (myPet.hunger > 20 && myPet.thirst > 20) {
				System.out.println(name + " needs to eat and drink now. Be careful, " + name + " might run away soon.");
				runAwayCounter += 1;
				if (runAwayCounter > 2) {
					System.out.println("You did not do a good job of taking care of " + name + ".");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " ran away!");
					System.exit(0);
				}
			}

		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(name + " is no longer your pet...");
	}
}
