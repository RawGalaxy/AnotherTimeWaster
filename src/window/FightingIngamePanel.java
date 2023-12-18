package window;
import javax.swing.*;
import entities.monsters;

public class FightingIngamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private monsters monster;
    private Timer timer;
	public FightingIngamePanel(monsters monster) {
        this.monster = monster;
        JLabel label = new JLabel("Fighting Scene Panel");
        add(label);
        // IMAGE/SCENE DO IT HERE YES, and when it comes to it change the output area aka get rid of it
        timer = new Timer(1000, e -> endFight());
        timer.setRepeats(false);
    }

    public void runFightSequence() {
    	int monsterPower = monster.getPower();
    	IngamePanel.outputArea.append("Fighting " + monster.getName() + " with " + monsterPower + " power\n");
        if(IngamePanel.hero.getPower() >= monster.getPower())
		{
        	IngamePanel.hero.winBattle(monster.getPower());
			IngamePanel.outputArea.append("Hero won and gain " + monster.getPower() / 2 + " power!\n");
		}
		else
		{
			monster.winBattle(IngamePanel.outputArea);
		}
        timer.start();
    }
    private void switchToPanel(String panel)
    {
    	GamePanel parent = (GamePanel) getParent();
    	parent.showPanel(panel);
    }
    private void endFight() {
        // Check the fight result and decide which panel to switch to
        if (IngamePanel.hero.getPower() >= monster.getPower()) {
            switchToPanel("IngamePanel"); // Switch back to IngamePanel if the hero wins
        } else {
            GamePanel parent = (GamePanel) getParent(); // Switch to GameOverPanel if the hero loses
            parent.showGameOver();
        }
    }
}
