import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BattleSystemTest {
	
	@Test
	public void test1() {
		Charizard charizard = new Charizard("喷火龙", 10);
		Pikachu pikachu = new Pikachu("皮卡丘", 8);
		assertEquals("皮卡丘", BattleSystem.battle(charizard, pikachu).name);
	}

	@Test
	public void test2() {
		Charizard charizard = new Charizard("喷火龙", 10);
		charizard.fly();
		Squirtle squirtle = new Squirtle("杰尼龟", 15);
		assertEquals("杰尼龟", BattleSystem.battle(charizard, squirtle).name);

		Pikachu pikachu = new Pikachu("皮卡丘", 20);
		assertEquals("皮卡丘", BattleSystem.battle(squirtle, pikachu).name);
	}

	@Test
	public void test3() {
		Pikachu pikachu = new Pikachu("皮卡丘", 5);
		Squirtle squirtle = new Squirtle("杰尼龟", 10);
		assertEquals("皮卡丘", BattleSystem.battle(pikachu, squirtle).name);

		pikachu.heal();
		squirtle.heal();

		assertEquals("皮卡丘", BattleSystem.battle(squirtle, pikachu).name);
	}
}
