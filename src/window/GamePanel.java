package window;
import java.awt.*;
import javax.swing.*;

import entities.monsters;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private CardLayout card = new CardLayout();
	private IngamePanel ingamePanel; // Reference to IngamePanel
	GameOverPanel gameOverPanel;
	WinningPanel winningPanel;
	GameMenu gameMenu;
	EndGame endGame;
	private boolean endGameShown = false; // Flag to track if EndGame panel was shown
	private MusicManager musicManager = new MusicManager();
	public GamePanel()
	{
		setLayout(card);
		gameMenu = new GameMenu();
		add(gameMenu, "GameMenu");
		ingamePanel = new IngamePanel();
		add(ingamePanel, "IngamePanel");
		endGame = new EndGame();
		add(endGame, "EndGame");
		winningPanel = new WinningPanel();
		winningPanel.setSwitchListener(this::showPanel);
		add(winningPanel, "WinningPanel");
		gameOverPanel = new GameOverPanel(); // Instantiate GameOverPanel
	    gameOverPanel.setSwitchListener(this::showPanel); // Set the listener
	    add(gameOverPanel, "GameOver"); // Then add it to the CardLayout
	    musicManager.playMusic("src/window/music/main_menu_theme_but_with_more_thumpy_bass.mp3");
	}
	public void showPanel(String name)
	{
		card.show(this, name);
		if ("IngamePanel".equals(name)) {
			ingamePanel.fadeIn(1000);
            ingamePanel.resumeAfterFight(); // Call the method on IngamePanel
        }
		else if ("EndGame".equals(name)) {
	        endGameShown = true; // Set flag when EndGame panel is shown
	    }
		if ("IngamePanel".equals(name)) {
            musicManager.playMusic("src/window/music/idle_music_for_ariq.mp3");
        } 
		else if ("GameMenu".equals(name)) {
            musicManager.playMusic("src/window/music/main_menu_theme_but_with_more_thumpy_bass.mp3");
        } 
        else if ("EndGame".equals(name)) {
            musicManager.playMusic("src/window/music/boss.mp3");
        }
        else if ("WinningPanel".equals(name)) {
            musicManager.playMusic("src/window/music/win_music.mp3");
        }
        else if ("GameOver".equals(name)) {
            musicManager.playMusic("src/window/music/main_menu_theme_but_with_more_thumpy_bass.mp3");
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
	    musicManager.playMusic("src/window/music/battle_moosic.mp3");
	    fightScenePanel.runFightSequence(); // Start the fight sequence 
	}
}
