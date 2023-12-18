package window;

import javax.swing.*;

public class GameOverPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelSwitchListener switchListener;
    Timer timer;
    public GameOverPanel() {
        JLabel label = new JLabel("L FOR U");
        add(label);
        timer = new Timer(1000, e -> initiateSwitch()); // Timer calls switchPanel after 5 seconds
        timer.setRepeats(false);
    }
    public void startTimer() {
        System.out.println("Timer started");
        timer.start();
    }
	public void initiateSwitch() 
	{
		if (switchListener != null) {
            switchListener.switchPanel("GameMenu");
        }
	}
    public void setSwitchListener(PanelSwitchListener listener) {
        this.switchListener = listener;
    }
}
