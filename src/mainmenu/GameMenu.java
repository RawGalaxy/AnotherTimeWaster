package mainmenu;
import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Image backgroundImage;
    private Image titleImage;

    private JButton playButton;
    private JButton helpButton;
    private JButton quitButton;

    public GameMenu() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Load images
        backgroundImage = new ImageIcon("/mainmenu/images/dfavegvawgw.png").getImage();
        titleImage = new ImageIcon("/mainmenu/images/timewaster.png").getImage();

        // Create and set up buttons
        playButton = createButton("/mainmenu/buttons/PlayButton.png");
        helpButton = createButton("/mainmenu/buttons/HelpButton.png");
        quitButton = createButton("/mainmenu/buttons/QuitButton.png");

        // Set button bounds (adjust as needed)
        int buttonWidth = 178;
        int buttonHeight = 81;
        int centerX = WIDTH / 2 - buttonWidth / 2;

        playButton.setBounds(centerX, 250, buttonWidth, buttonHeight);
        helpButton.setBounds(centerX, 250 + buttonHeight + 20, buttonWidth, buttonHeight); // 20 pixels gap between buttons
        quitButton.setBounds(centerX, 250 + 2 * (buttonHeight + 20), buttonWidth, buttonHeight);

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
        Graphics2D g2d = (Graphics2D) g;

        // Draw the background image
        g2d.drawImage(backgroundImage, 0, 0, this);

        // Draw the title image
        g2d.drawImage(titleImage, WIDTH / 2 - titleImage.getWidth(null) / 2, 0, this); // Adjust y coordinate as needed
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GameMenu());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
