package entities;

public class Orc extends monsters{
	private int powerLevel;
	private String name;
	public Orc(int power) 
	{
		super(power);
		this.powerLevel = power;
		this.name = "Orc";
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
