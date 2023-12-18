package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageButton extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon normalIcon;
    private ImageIcon hoverIcon;
    private ImageIcon pressedIcon;

    public ImageButton(ImageIcon normalIcon, ImageIcon hoverIcon, ImageIcon pressedIcon) {
        this.normalIcon = normalIcon;
        this.hoverIcon = hoverIcon;
        this.pressedIcon = pressedIcon;
        setIcon(normalIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(normalIcon);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(pressedIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(hoverIcon);
            }
        });
    }
}

