package window;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import entities.*;

public class IngamePanel extends FadingPanel{
	private static final long serialVersionUID = 1L;
	public static mainCharacter hero;
    private Random random;
    public static JLabel powerLabel;
    public static JTextArea outputArea; //get rid of this later on when adding images/scene
    public static monsters monster;
    private JPanel monsterPanel; // Panel to hold monster buttons
    private int currentRound = 0; // Current round counter
    private final int maxRounds = 5;
    private ImageIcon normalIcon;
    private ImageIcon hoverIcon;
    private ImageIcon pressedIcon;
    private Image backgroundImage;

    public IngamePanel() {
    	setLayout(new BorderLayout());
        random = new Random();
        hero = new mainCharacter(random.nextInt(5, 16), "Joe");
        JPanel topPanel = new JPanel();
        powerLabel = new JLabel("Hero Power: " + hero.getPower());
        topPanel.add(powerLabel);
        add(topPanel, BorderLayout.NORTH);
        normalIcon = new ImageIcon("src/window/buttons/Ingame/ClosedDoor.png"); // Fix the size/resolution
        hoverIcon = new ImageIcon("src/window/buttons/Ingame/SlightlyOpen.png");
        pressedIcon = new ImageIcon("src/window/buttons/Ingame/OpenedDoor.png");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        monsterPanel = new JPanel(new GridBagLayout());
        add(monsterPanel, BorderLayout.CENTER);
    	backgroundImage = new ImageIcon("src/window/images/dfavegvawgw.png").getImage();
        System.out.println("Background Image Dimensions: " + backgroundImage.getWidth(null) + "x" + backgroundImage.getHeight(null));
        topPanel.setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        monsterPanel.setOpaque(false);

        spawnMonsters();
    }

    private void spawnMonsters() {
    	monsterPanel.removeAll();
    	monsterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100)); // Set layout with horizontal gap
        int numberOfMonsters = random.nextInt(2, 6); // Random number of monsters
        for (int i = 0; i < numberOfMonsters; i++) {
            int monsterPower = (i == 0) ? random.nextInt(1, hero.getPower() + 1) : random.nextInt(Math.max(15, hero.getPower() - 10), hero.getPower() + 15);
            monsters monster; // Or randomize monster type
            int monsterType = random.nextInt(3);
            switch(monsterType)
            {
	            case 0: 
	                monster = new goblin(monsterPower); 
	                break;
	            case 1: 
	                monster = new Kobold(monsterPower); 
	                break;
	            default: 
	                monster = new Orc(monsterPower);
            }
            // JButton monsterButton = new JButton(monster.getName() + " (" + monster.getPower() + ")");
            JPanel monsterCon = new JPanel();
            monsterCon.setLayout(new BoxLayout(monsterCon, BoxLayout.Y_AXIS));
         // Create and add a label for the monster's name
            JLabel nameLabel = new JLabel(monster.getName());
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            monsterCon.add(nameLabel);

            // Create and add the monster button
            ImageButton monsterButton = new ImageButton(normalIcon, hoverIcon, pressedIcon);
            monsterButton.addActionListener(e -> fight(monster));
            monsterCon.add(monsterButton);

            // Create and add a label for the monster's power
            JLabel powerLabel = new JLabel("Power: " + monster.getPower());
            powerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            monsterCon.add(powerLabel);

            // Add the container panel to the main monster panel
            monsterPanel.add(monsterCon);
        }
        monsterPanel.revalidate(); // Refresh the panel to display new buttons
        monsterPanel.repaint();
        if(currentRound == maxRounds) switchToPanel("EndGame");
        else currentRound++;
    }
    private void fight(monsters selectedMonster) {
        if (selectedMonster != null) switchToFightScene(selectedMonster);
    }
    public void resumeAfterFight() {
        updatePowerLabel();
        spawnMonsters(); // Refresh the monsters after a fight
    }
    public void switchToPanel(String panel)
    {
    	GamePanel parent = (GamePanel) getParent();
    	parent.showPanel(panel);
    }

    private void updatePowerLabel() 
    {
        powerLabel.setText("Hero Power: " + IngamePanel.hero.getPower());
    }
    private void switchToFightScene(monsters monster) {
        GamePanel parent = (GamePanel) getParent();
        parent.switchToFightScenePanel(monster); // A method in GamePanel to switch views
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent called - Panel size: " + getWidth() + "x" + getHeight());
        Graphics2D g2d = (Graphics2D) g.create();
        if (backgroundImage != null) {
            System.out.println("Drawing background image");
        }
        else System.out.println("Background image is null");
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
        g2d.dispose();
    }
}
