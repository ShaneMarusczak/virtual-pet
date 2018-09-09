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
		int testHunger1 = pet.getHunger();
		pet.tick();
		int testHunger2 = pet.getHunger();
		assertTrue(testHunger1 <= testHunger2);
	}

	@Test
	public void shouldLowerThirstWhenDrinks() {
		int testThirst1 = pet.getThirst();
		pet.giveDrink();
		int testThirst2 = pet.getThirst();
		assertTrue(testThirst2 < testThirst1);
	}

	@Test
	public void shouldLowerHungerWhenEats() {
		int testHunger1 = pet.getHunger();
		pet.giveFood();
		int testHunger2 = pet.getHunger();
		assertTrue(testHunger2 < testHunger1);
	}
	
	@Test
	public void shouldReturnTrueWhenNeedsToPlay() {
		assertTrue(pet.needsToPlay(7));
		
	}
	
	@Test
	public void shouldLowerEnergyWhenPlays() {
		int testEnergy1 = pet.getEnergyLevel();
		pet.playWith();
		int testEnergy2 = pet.getEnergyLevel();
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
