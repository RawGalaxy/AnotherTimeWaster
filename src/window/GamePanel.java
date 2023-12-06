package window;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel{
	private CardLayout card = new CardLayout();
	public GamePanel()
	{
		setLayout(card);
		add(new GameMenu(), "GameMenu");
		add(new IngamePanel(), "IngamePanel");
		add(new FightingIngamePanel(), "FightingPanel");
		add(new GameOverPanel(), "GameOver");
	}
	public void showPanel(String name)
	{
		card.show(this, name);
	}
}
