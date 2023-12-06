package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Kobold extends monsters{
	private int powerLevel;
	public Kobold(int power) 
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
				"Snivels the Kobold", "Glimwick the Kobold", "Ratchit the Kobold", "Skreet the Kobold", "Nibnab the Kobold", "Fizzle the Kobold", "Krick the Kobold", "Grex the Kobold", "Poxjib the Kobold", "Zigzag the Kobold", "Scraptooth the Kobold", "Tinktak the Kobold", "Jibjit the Kobold", "Wizzle the Kobold", "Grit the Kobold", "Sneakwhisk the Kobold", "Blinks the Kobold", "Gnash the Kobold", "Rattlecap the Kobold", "Flintknack the Kobold", "Skivver the Kobold", "Quicksnip the Kobold", "Coggle the Kobold", "Pipfit the Kobold", "Zazzle the Kobold", "Twitchtail the Kobold", "Skitterclaw the Kobold", "Gobble the Kobold", "Prickle the Kobold", "Mizzik the Kobold"
				));
		int index = ran.nextInt(nameList.size()); // Get a random index
        return nameList.get(index);
	}
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
