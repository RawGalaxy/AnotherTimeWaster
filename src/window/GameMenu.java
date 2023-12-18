package window;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameMenu extends FadingPanel {
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();


    private Image backgroundImage;
    private Image titleImage;

    private JButton playButton;
    private JButton helpButton;
    private JButton quitButton;

    public GameMenu() {
        // Load images
        backgroundImage = new ImageIcon("src/window/images/dfavegvawgw.png").getImage();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        titleImage = new ImageIcon("src/window/images/timewaster.png").getImage();
        // Create and set up buttons
        playButton = createButton("src/window/buttons/PlayButton.png");
        helpButton = createButton("src/window/buttons/HelpButton.png");
        quitButton = createButton("src/window/buttons/QuitButton.png");
        // Set button bounds (adjust as needed)
        int buttonWidth = 311;
        int buttonHeight = 137;
        int centerX = (int)width / 2 - buttonWidth / 2;
        int startY = 250;
        
        playButton.setBounds(centerX, startY, buttonWidth, buttonHeight);
        playButton.addActionListener(e -> switchToPanel("IngamePanel"));
        
        helpButton.setBounds(centerX, startY + buttonHeight + 20, buttonWidth, buttonHeight); // 20 pixels gap between buttons
        helpButton.addActionListener(e -> switchToPanel("HelpPanel"));
        
        quitButton.setBounds(centerX, startY + 2 * (buttonHeight + 20), buttonWidth, buttonHeight);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add buttons to panel
        setLayout(null); // Use absolute positioning
        add(playButton);
        add(helpButton);
        add(quitButton);

    }

    private JButton createButton(String imagePath) {
        JButton button = new JButton(new ImageIcon(imagePath));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        return button;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Calculate the appropriate scaling factor
        double scaleWidth = getWidth() / (double) backgroundImage.getWidth(null);
        double scaleHeight = getHeight() / (double) backgroundImage.getHeight(null);
        double scale = Math.min(scaleWidth, scaleHeight); // Choose the smaller scale to fit in the window

        // Calculate the new image dimensions while maintaining the aspect ratio
        int newImageWidth = (int) (backgroundImage.getWidth(null) * scale);
        int newImageHeight = (int) (backgroundImage.getHeight(null) * scale);

        // Calculate the position to center the image
        int x = (getWidth() - newImageWidth) / 2;
        int y = (getHeight() - newImageHeight) / 2;

        // Draw the scaled image
        g2d.drawImage(backgroundImage, x, y, newImageWidth, newImageHeight, this);

        // Draw the title image
        g2d.drawImage(titleImage, 800 - titleImage.getWidth(null) / 2, 0, this);
        g2d.dispose();
    }
    private void switchToPanel(String panel)
    {
    	GamePanel parent = (GamePanel) getParent();
    	parent.showPanel(panel);
    }
}
