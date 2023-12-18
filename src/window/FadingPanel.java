package window;

import javax.swing.*;
import java.awt.*;

public class FadingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private float opacity = 0.0f;

    public FadingPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(opacity));
        super.paintComponent(g2d);
        g2d.dispose();
    }

    public void setOpacity(float value) {
        this.opacity = value;
        repaint();
    }

    public void fadeIn(int duration) {
        Timer timer = new Timer(duration / 100, e -> {
            opacity += 0.01f;
            if (opacity > 1.0f) {
                opacity = 1.0f;
                ((Timer) e.getSource()).stop();
            }
            setOpacity(opacity);
        });
        timer.start();
    }

    public void fadeOut(int duration, Runnable onComplete) {
        Timer timer = new Timer(duration / 100, e -> {
            opacity -= 0.01f;
            if (opacity < 0.0f) {
                opacity = 0.0f;
                ((Timer) e.getSource()).stop();
                if (onComplete != null) onComplete.run();
            }
            setOpacity(opacity);
        });
        timer.start();
    }
}
