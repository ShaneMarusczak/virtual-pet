package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {
	static VirtualPet myPet = new VirtualPet();
	static Scanner input = new Scanner(System.in);;

	public static void main(String[] args) {
		int menuInput;
		int inputCounter = 0;
		System.out.println("Welcome!");
		String ready;
		do {
			System.out.println("Are you ready to take care of very own Virtual Dog? (y/n)");
			ready = input.nextLine();
			if (!ready.equals("y")) {
				System.out.println("This is a big resonsibility!");
			}
		} while (!ready.equals("y"));
		myPet.tick();
		myPet.tick();
		boolean playingGame = true;
		System.out.println("What would you like to name your pet?");
		String name = input.nextLine();
		while (playingGame) {
			do {
				System.out.println("What would you like to do with your pet?");
				System.out.println("Enter 1 to feed your pet.");
				System.out.println("Enter 2 to give your pet a drink.");
				System.out.println("Enter 3 to play with your pet.");
				System.out.println("Enter 4 to let your pet take a nap.");
				System.out.println("Enter 5 to quit.");
				menuInput = input.nextInt();
				input.nextLine();
				inputCounter += 1;

			} while (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5);
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
				if(myPet.tiredness>12) {
					System.out.println("VERY TIRED!");
				}
			}
			if (myPet.isHungry(myPet.hunger)) {
				System.out.println(name + " is getting hungry.");
				if(myPet.hunger>12) {
					System.out.println("VERY HUNGRY!");
				}
			}
			if (myPet.isThirsty(myPet.thirst)) {
				System.out.println(name + " is getting thirsty.");
				if(myPet.thirst>12) {
					System.out.println("VERY THIRSTY!");
				}
			}
			if (myPet.needsToPlay(myPet.energyLevel)) {
				System.out.println(name + " would like to play!");
				if(myPet.energyLevel>12) {
					System.out.println("PLAY WITH ME NOW!");
				}
			}

			if (menuInput == 1) {
				//giving food
				if (!myPet.isHungry(myPet.hunger)) {
					System.out.println(name + " is not hungry.");
				} else {
					myPet.giveFood();
					System.out.println(name + " ate everything you gave!");
				}
			}
			if(menuInput == 2) {
				//giving water
			}
			if(menuInput==3) {
				//playing
			}
			if(menuInput==4) {
				//nap
			}
			if(menuInput==5) {
				//exit
			}

		}
	}
}
