package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Orc extends monsters{
	private int powerLevel;
	public Orc(int power) 
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
				"Grumshar the Orc", "Borug the Orc", "Mogthol the Orc", "Karnak the Orc", "Zugor the Orc", "Rendwarg the Orc", "Urgash the Orc", "Thokk the Orc", "Grommash the Orc", "Skarg the Orc", "Vrakthar the Orc", "Bludbash the Orc", "Gorog the Orc", "Torgar the Orc", "Krug the Orc", "Ulkash the Orc", "Zorth the Orc", "Mokrag the Orc", "Snarlgut the Orc", "Bragdor the Orc", "Grimfang the Orc", "Rogthar the Orc", "Kargob the Orc", "Thrak the Orc", "Gorrum the Orc", "Nargol the Orc", "Rukthar the Orc", "Zugzug the Orc", "Groth the Orc", "Bolgar the Orc"
				));
		int index = ran.nextInt(nameList.size()); // Get a random index
        return nameList.get(index);
	}
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
