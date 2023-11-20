package entities;

public class monsters {
	private int powerLevel;
	private String name;
	
	public monsters(int power)
	{
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
	public void winBattle() {
		System.out.println("You lost.\n");
	}
}
