package virtualpet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet pet = new VirtualPet();

	@Test
	public void shouldReturnTrueIfHungry() {
		assertTrue(pet.isHungry(7));
	}

	@Test
	public void shouldReturnTrueIfThirsty() {
		assertTrue(pet.isThirsty(7));
	}

	@Test
	public void shouldReturnBooleanForWaste() {
		boolean needsToGo = pet.needsToGo();
	}

	@Test
	public void shouldChangeOnTick() {
		int testHunger1 = pet.hunger;
		pet.tick();
		int testHunger2 = pet.hunger;
		assertTrue(testHunger1 <= testHunger2);
	}

	@Test
	public void shouldLowerThirstWhenDrinks() {
		int testThirst1 = pet.thirst;
		pet.giveDrink();
		int testThirst2 = pet.thirst;
		assertTrue(testThirst2 < testThirst1);
	}

	@Test
	public void shouldLowerHungerWhenEats() {
		int testHunger1 = pet.hunger;
		pet.giveFood();
		int testHunger2 = pet.hunger;
		assertTrue(testHunger2 < testHunger1);
	}
	
	@Test
	public void shouldReturnTrueWhenNeedsToPlay() {
		assertTrue(pet.needsToPlay(7));
		
	}
	
	@Test
	public void shouldLowerEnergyWhenPlays() {
		int testEnergy1 = pet.energyLevel;
		pet.playWith();
		int testEnergy2 = pet.energyLevel;
		assertTrue(testEnergy2 < testEnergy1);
	}
	
	@Test
	public void shouldBiteWhenAngressive() {
		boolean mightBite = pet.mightBite();
	}
	
	@Test
	public void shouldReturnTrueWhenTired() {
		assertTrue(pet.isTired(11));
	}
}
