package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ogre extends monsters{
	private int powerLevel;
	public Ogre(int power) 
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
				"Mogthar the Mighty", "Gronk Skullcrusher", "Rumbol Bonebreaker", "Korgul the Tyrant", "Brak Doomfist", "Zorgoth the Unyielding", "Throgar the Colossus", "Gromok Ironhide", "Vorgash the Conqueror", "Bragdok Warlord", "Thrumm the Mountain", "Kragthor the Unbeaten", "Vulgor the Merciless", "Gorom the Destroyer", "Rugolth the Dreaded", "Mokthar the Devastator", "Gruglok the Fearbringer", "Bolgar the Savage", "Zugrok the Annihilator", "Krothu the Invincible", "Golmak the Overlord", "Rukthok the Ruler", "Blarg the Oppressor", "Gurgthak the Formidable", "Torgoth the Unstoppable", "Mugrok the Imperator", "Grakthul the Supreme", "Vrog the Dominator", "Krum the Earthshaker", "Gorlok the Warbringer"
				));
		int index = ran.nextInt(nameList.size()); // Get a random index
        return nameList.get(index);
	}
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
