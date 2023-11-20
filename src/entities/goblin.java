package entities;

public class goblin extends monsters 
{
	private int powerLevel;
	private String name;
	public goblin(int power) 
	{
		super(power);
		this.powerLevel = power;
		this.name = "Goblin";
	}
	@Override
	public int getPower()
	{
		return this.powerLevel;
	}
	public String getName()
	{
		return this.name;
	}
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
