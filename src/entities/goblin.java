package entities;

import java.util.*;

public class goblin extends monsters 
{
	private int powerLevel;
	public goblin(int power) 
	{
		super(power);
		this.powerLevel = power;
	}
	@Override
	public int getPower()
	{
		return this.powerLevel;
	}
	public String getName()
	{
		Random ran = new Random();
		List<String> nameList = new ArrayList<>(Arrays.asList(
				"Grizznak the Goblin", "Snarltooth the Goblin", "Zogbug the Goblin",  "Fizzwinkle the Goblin", "Griblik the Goblin", "Snotgrot the Goblin", "Mucknose the Goblin", "Pogglewump the Goblin", "Skabnab the Goblin", "Blort the Goblin", "Wartnose the Goblin", "Shrieksnarl the Goblin", "Yikyak the Goblin", "Squigglefist the Goblin", "Gobrot the Goblin", "Slinknab the Goblin", "Vexgob the Goblin", "Rattlebag the Goblin", "Grotsnik the Goblin", "Bogglethump the Goblin", "Snivelsnout the Goblin", "Grubgrub the Goblin", "Skulktooth the Goblin", "Glumgrot the Goblin", "Pustulio the Goblin", "Scumguzzle the Goblin", "Jinxjaw the Goblin", "Sludgebelly the Goblin", "Fizzlecrank the Goblin", "Grotmunch the Goblin"
				));
		int index = ran.nextInt(nameList.size()); // Get a random index
        return nameList.get(index);
	}
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
