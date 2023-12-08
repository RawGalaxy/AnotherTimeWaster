package window;
import java.awt.*;
import javax.swing.*;

import entities.monsters;

public class GamePanel extends JPanel{
	private CardLayout card = new CardLayout();
	private IngamePanel ingamePanel; // Reference to IngamePanel
	GameOverPanel gameOverPanel;
	WinningPanel winningPanel;
	private boolean endGameShown = false; // Flag to track if EndGame panel was shown
	public GamePanel()
	{
		setLayout(card);
		add(new GameMenu(), "GameMenu");
		ingamePanel = new IngamePanel();
		add(ingamePanel, "IngamePanel");
		add(new EndGame(), "EndGame");
		winningPanel = new WinningPanel();
		winningPanel.setSwitchListener(this::showPanel);
		add(winningPanel, "WinningPanel");
		gameOverPanel = new GameOverPanel(); // Instantiate GameOverPanel
	    gameOverPanel.setSwitchListener(this::showPanel); // Set the listener
	    add(gameOverPanel, "GameOver"); // Then add it to the CardLayout
	}
	public void showPanel(String name)
	{
		card.show(this, name);
		if ("IngamePanel".equals(name)) {
            ingamePanel.resumeAfterFight(); // Call the method on IngamePanel
        }
		else if ("EndGame".equals(name)) {
	        endGameShown = true; // Set flag when EndGame panel is shown
	    }
	}
	public void redirectAfterEndGame() {
	    System.out.println("redirectAfterEndGame called, endGameShown: " + endGameShown);
	    if (endGameShown) {
	        showWinningPanel();
	        endGameShown = false; // Reset the flag
	    } else {
	        // Other logic if EndGame was not shown
	    }
	}
	public void showGameOver() {
        card.show(this, "GameOver");
        gameOverPanel.startTimer(); // Trigger the switch back process
    }
	public void showWinningPanel() {
        card.show(this, "WinningPanel");
        winningPanel.startTimer(); // Trigger the switch back process
    }
	public void switchToFightScenePanel(monsters monster) {
	    FightingIngamePanel fightScenePanel = new FightingIngamePanel(monster);
	    add(fightScenePanel, "FightScene");
	    card.show(this, "FightScene"); // Assuming you have added FightScenePanel with this name
	    fightScenePanel.runFightSequence(); // Start the fight sequence
	}
}
