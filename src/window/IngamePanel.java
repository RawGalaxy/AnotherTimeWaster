package window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import entities.*;

public class IngamePanel extends JPanel{
	public static mainCharacter hero;
    private Random random;
    public static JLabel powerLabel;
    public static JTextArea outputArea; //get rid of this later on when adding images/scene
    public static monsters monster;
    private JPanel monsterPanel; // Panel to hold monster buttons
    private int currentRound = 0; // Current round counter
    private final int maxRounds = 5;

    public IngamePanel() {
    	setLayout(new BorderLayout());
        random = new Random();
        hero = new mainCharacter(random.nextInt(5, 16), "Joe");
        JPanel topPanel = new JPanel();
        powerLabel = new JLabel("Hero Power: " + hero.getPower());
        topPanel.add(powerLabel);
        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        monsterPanel = new JPanel(new GridBagLayout());
        add(monsterPanel, BorderLayout.CENTER);
        
        spawnMonsters();
    }

    private void spawnMonsters() {
    	monsterPanel.removeAll();
    	monsterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100)); // Set layout with horizontal gap
        int numberOfMonsters = random.nextInt(2, 6); // Random number of monsters
        for (int i = 0; i < numberOfMonsters; i++) {
            int monsterPower = (i == 0) ? random.nextInt(1, hero.getPower() + 1) : random.nextInt(Math.max(15, hero.getPower() - 10), hero.getPower() + 15);
            monsters monster; // Or randomize monster type
            int monsterType = random.nextInt(3);
            switch(monsterType)
            {
	            case 0: 
	                monster = new goblin(monsterPower); 
	                break;
	            case 1: 
	                monster = new Kobold(monsterPower); 
	                break;
	            default: 
	                monster = new Orc(monsterPower);
            }
            JButton monsterButton = new JButton(monster.getName() + " (" + monster.getPower() + ")");
            monsterButton.addActionListener(e -> fight(monster));
            monsterPanel.add(monsterButton);
        }
        monsterPanel.revalidate(); // Refresh the panel to display new buttons
        monsterPanel.repaint();
        if(currentRound == maxRounds) endGame();
        else currentRound++;
    }
    private void fight(monsters selectedMonster) {
        if (selectedMonster != null) switchToFightScene(selectedMonster);
    }
    public void resumeAfterFight() {
        updatePowerLabel();
        spawnMonsters(); // Refresh the monsters after a fight
    }
    public void switchToPanel(String panel)
    {
    	GamePanel parent = (GamePanel) getParent();
    	parent.showPanel(panel);
    }
    private void endGame()
    {
    	switchToPanel("EndGame"); //Winning
    }

    private void updatePowerLabel() 
    {
        powerLabel.setText("Hero Power: " + IngamePanel.hero.getPower());
    }
    private void switchToFightScene(monsters monster) {
        GamePanel parent = (GamePanel) getParent();
        parent.switchToFightScenePanel(monster); // A method in GamePanel to switch views
    }
}
