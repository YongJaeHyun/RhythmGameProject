package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasicImage.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEnteredImage.png"));
	private ImageIcon optionButtonBasicImage = new ImageIcon(Main.class.getResource("../images/optionButtonBasicImage.png"));
	private ImageIcon optionButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/optionButtonEnteredImage.png"));

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackgroundEdit.png"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton optionButton = new JButton(optionButtonBasicImage);

	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		
		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		startButton.setBounds(560,490,150,80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)  {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				new songSelectionMenu();
				setVisible(false);
				introMusic.close();
			}
		});
		
		add(startButton);
		
		optionButton.setBounds(510,600,250,90);
		optionButton.setBorderPainted(false);
		optionButton.setContentAreaFilled(false);
		optionButton.setFocusPainted(false);
		optionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)  {
				optionButton.setIcon(optionButtonEnteredImage);
				optionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				optionButton.setIcon(optionButtonBasicImage);
				optionButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(optionButton);

	
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
