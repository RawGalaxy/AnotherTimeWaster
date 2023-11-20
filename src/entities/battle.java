package entities;

public class battle{

	public void fight(mainCharacter hero, monsters monster)
	{
		if(hero.getPower() >= monster.getPower())
		{
			hero.winBattle(monster.getPower());
			System.out.println("Hero won and gain " + monster.getPower() / 2 + " power!\n");
		}
		else
		{
			monster.winBattle();
		}
			
	}
}
