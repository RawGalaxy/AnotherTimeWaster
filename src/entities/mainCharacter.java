package entities;

public class mainCharacter {
	private int powerLevel;
	private String name;
	
	public mainCharacter(int power, String name)
	{
		this.name = name;
		this.powerLevel = power;
	}
	public int getPower()
	{
		return this.powerLevel;
	}
	public String getName()
	{
		return this.name;
	}
	public void winBattle(int powerGain) {
	    this.powerLevel += (powerGain / 2);
	}
}
