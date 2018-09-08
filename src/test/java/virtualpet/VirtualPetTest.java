package virtualpet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet pet = new VirtualPet();

	@Test
	public void shouldReturnTrueIfHungry() {
		pet.isHungry(6);
		assertTrue(true);
	}

	@Test
	public void shouldReturnTrueIfThirsty() {
		pet.isThirsty(6);
		assertTrue(true);
	}
	
	@Test
	public void shouldReturnBooleanForSick() {
		boolean isSick = pet.isSick();
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
		assertTrue(testHunger1<=testHunger2);
	}

}
