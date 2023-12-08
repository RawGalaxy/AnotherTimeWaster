package window;

import javax.swing.*;

public class WinningPanel extends JPanel {
	Timer timer;
	private PanelSwitchListener switchListener;
	public WinningPanel() {
		JLabel label = new JLabel("W FOR U");
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
