package window;
import javax.swing.*;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public GameFrame()
	{
		setTitle("Another Time Waster, horray!");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new GamePanel());
	}
	public static void main(String[] args)
	{
		java.awt.EventQueue.invokeLater(() -> {
			new GameFrame().setVisible(true);
		});
	}
}
