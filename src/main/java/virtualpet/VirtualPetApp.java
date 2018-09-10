package virtualpet;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApp {
	static VirtualPet myPet = new VirtualPet();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int menuInput;
		String ready;
		int inputCounter = 0;
		System.out.println("Welcome!");
		System.out.println("               "
				+ "__\n             /\\\\/'-,\n      ,--'''''   /\"\n ____,'.  )       \\___\n'\"\"\"\"\"------'\"\"\"`-----'");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		do {
			System.out.println("Are you ready to take care of very own Virtual Pet? (y/n)");
			ready = input.nextLine();
			if (!ready.equals("y")) {
				System.out.println("This is a big resonsibility!");
			}
		} while (!ready.equals("y"));
		myPet.tick();
		boolean playingGame = true;
		System.out.println("What would you like to name your pet?");
		String name = input.nextLine();
		while (playingGame) {
			do {
				System.out.println("\nWhat would you like to do with " + name + "?");
				System.out.println("Enter 1 to feed " + name + ".");
				System.out.println("Enter 2 to give " + name + " a drink.");
				System.out.println("Enter 3 to play with " + name + ".");
				System.out.println("Enter 4 to let " + name + " take a nap.");
				System.out.println("Enter 5 to do nothing.");
				System.out.println("Enter 6 to do quit.");
				menuInput = input.nextInt();
				input.nextLine();
				inputCounter += 1;
				myPet.tick();

			} while (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5
					&& menuInput != 6);
			if (menuInput == 1) {
				if (!myPet.isHungry(myPet.getHunger())) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " is not hungry.");
					System.out.println("");
				} else {
					myPet.giveFood();
					System.out.printf(
							"    ,    /-.\n   ((___/ __>\n   /      }\n   \\\\ .--.( \n    \\\\   \\\\  /___\\");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

					System.out.println("\n" + name + " ate everything you gave!");
					System.out.println("");
				}
			}
			if (menuInput == 2) {
				if (!myPet.isThirsty(myPet.getThirst())) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " is not thirsty.");
					System.out.println("");
				} else {
					myPet.giveDrink();
					System.out.printf(
							"    ,    /-.\n   ((___/ __>\n   /      }\n   \\\\ .--.( \n    \\\\   \\\\  /___\\\n");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println("\n" + name + " drank the whole bowl!");
					System.out.println("");
				}
			}
			if (menuInput == 3) {
				if (!myPet.needsToPlay(myPet.getEnergyLevel())) {
					System.out.println(name + " does not want to play.");
					System.out.println("");
				} else {
					myPet.playWith();
					System.out.printf(
							"             ;~~,__\n:-....,-------'`-'._.'\n`-,,,  ,       ;'~~'\n ,'_,'~.__; '--.\r\n//'       ````(;\r\n`-'\n");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println("\n" + name + " had so much fun playing!");
					System.out.println("");
				}
			}
			if (menuInput == 4) {
				if (!myPet.isTired(myPet.getTiredness())) {
					System.out.println(name + " is not sleepy.");
					System.out.println("");
				} else {
					myPet.takeNap();
					System.out.println("               "
							+ "__\n             /\\\\/'-,\n      ,--'''''   /\"\n ____,'.  )       \\___\n'\"\"\"\"\"------'\"\"\"`-----'");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " had a great nap!");
					System.out.println("");
				}
			}
			if (menuInput == 5) {
				myPet.tick();
			}
			if (menuInput == 6) {
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
					System.out.println(
							" __      _\n \\.'---.//|\n |\\\\./|  \\\\/\n _|.|.|_  \\\n/(  ) ' '  \\\n|  \\/   . |  \\\n\\_/\\__/| |\r\n"
									+ " V  /V / |\n/__/ /\r\n" + "\\___/\\\r\n");
					System.out.println("\n" + name + " just bit you!");
				} else if (myPet.isSick()) {
					while (myPet.getSick() == 1) {
						System.out.println("\n" + name + " is sick.");
						System.out.println("Take " + name + " to the vet?(y/n)");
						String takeToVet = input.nextLine();
						if (takeToVet.equals("y")) {
							System.out.println(name + " made a full recovery!");
							myPet.notSick();
						} else {
							System.out.println(name + " is very ill.");
							myPet.tick();
							myPet.isSick();
						}
					}
				} else if (myPet.needsToGo()) {
					System.out.println("\n" + name + " needs to go outside.");
					System.out.println("Let " + name + " out?(y/n)");
					String letOut = input.nextLine();
					if (letOut.equals("y")) {
						System.out.println(name + " feels much better!");
					} else {
						System.out.println(name + " had an accident. Better clean it up.");
						myPet.tick();
					}
				}
				inputCounter = 0;
			}

			if (myPet.isTired(myPet.getTiredness())) {
				System.out.println("\n" + name + " is getting tired.");
				if (myPet.getTiredness() > 13) {
					System.out.println("VERY TIRED!");
				}
			}
			if (myPet.isHungry(myPet.getHunger())) {
				System.out.println("\n" + name + " is getting hungry.");
				if (myPet.getHunger() > 17) {
					System.out.println("VERY HUNGRY!");
				}
			}
			if (myPet.isThirsty(myPet.getThirst())) {
				System.out.println("\n" + name + " is getting thirsty.");
				if (myPet.getThirst() > 15) {
					System.out.println("VERY THIRSTY!");
				}
			}
			if (myPet.needsToPlay(myPet.getEnergyLevel())) {
				System.out.println("\n" + name + " would like to play!");
				if (myPet.getEnergyLevel() > 12) {
					System.out.println("PLAY WITH ME NOW!");
				}
			}
			if (myPet.getHunger() > 15 && myPet.getThirst() > 15) {
				System.out.println(
						"\n" + name + " needs to eat and drink now. Be careful, " + name + " might run away soon.");
				myPet.increaseRunAway();
				if (myPet.willRunAway()) {
					System.out.println("You did not do a good job of taking care of " + name + ".\n\n");
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " ran away!");
					System.exit(0);
				}
			}
			if (myPet.getHunger() > 10 && myPet.getEnergyLevel() > 10 && myPet.getHappiness() < 5) {
				System.out.println(name + " decided to eat your curtains!");
			}
			if (myPet.isUnhappy(myPet.getHappiness())) {
				System.out.println("\n" + name + " is getting very unhappy.");
				myPet.increaseRunAway();
				if (myPet.willRunAway()) {
					System.out.println("You did not do a good job of taking care of " + name + ".\n\n");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println(name + " ran away!");
					System.exit(0);
				}
			}

			if (!myPet.isUnhappy(myPet.getHappiness()) && !myPet.isTired(myPet.getTiredness())
					&& !myPet.isHungry(myPet.getHunger()) && !myPet.isThirsty(myPet.getThirst())) {
				System.out.println(name + " is happy!");
				if (myPet.getRunAway() > 0) {
					myPet.lowerRunAway();
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
