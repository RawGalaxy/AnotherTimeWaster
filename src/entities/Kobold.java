package entities;

public class Kobold extends monsters{
	private int powerLevel;
	private String name;
	public Kobold(int power) 
	{
		super(power);
		this.powerLevel = power;
		this.name = "Kobold";
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
