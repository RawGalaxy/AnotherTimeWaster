package window;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.*;
import javax.swing.*;
import entities.*;

public class EndGame extends JPanel {
	Random random = new Random();
	private JPanel monsterPanel;
	
	
	public EndGame()
	{
		monsterPanel = new JPanel(new GridBagLayout());
        add(monsterPanel, BorderLayout.CENTER);
		monsterPanel.removeAll();
    	monsterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100));
		monsterPanel = new JPanel(new GridBagLayout());
        add(monsterPanel, BorderLayout.CENTER);
		//random.nextInt(Math.max(15, hero.getPower() - 5), hero.getPower() + 20)
		int monsterPower = random.nextInt(Math.max(15, IngamePanel.hero.getPower() - 5), IngamePanel.hero.getPower() + 20);
		monsters ogre = new Ogre(monsterPower);
		JButton monsterButton = new JButton(ogre.getName() + " (" + ogre.getPower() + ")");
        monsterButton.addActionListener(e -> fight(ogre));
        monsterPanel.add(monsterButton);
	}
	private void fight(monsters selectedMonster) {
        if (selectedMonster != null) switchToFightScene(selectedMonster);
    }
	private void switchToFightScene(monsters monster) {
        GamePanel parent = (GamePanel) getParent();
        parent.switchToFightScenePanel(monster); // A method in GamePanel to switch views

        parent.redirectAfterEndGame();
    }
}
