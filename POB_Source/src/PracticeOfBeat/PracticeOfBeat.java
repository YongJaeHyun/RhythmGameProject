package PracticeOfBeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PracticeOfBeat extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon startButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/startButtonBasicImage.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEnteredImage.png"));
	private ImageIcon optionButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/optionButtonBasicImage.png"));
	private ImageIcon optionButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/optionButtonEnteredImage.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/exitButtonBasicImage.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/exitButtonEnteredImage.png"));
	private ImageIcon previousButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/previousButtonBasicImage.png"));
	private ImageIcon previousButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/previousButtonEnteredImage.png"));

	private Image selectedImage = new ImageIcon(
			Main.class.getResource("../images/InTheBlueShirt_ClusterA(Fusq_Remix).png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
	private Image Title = new ImageIcon(Main.class.getResource("../images/introBackgroundTitleImage.png")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JLabel songSelectScreen = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton optionButton = new JButton(optionButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton previousButton = new JButton(previousButtonBasicImage);

	private boolean isMainScreen = false;
	private boolean isOptionScreen = false;

	private int mouseX, mouseY;

	public PracticeOfBeat() {
		setUndecorated(true);
		setTitle("Practice Of Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		

		// 메뉴바 창 설정 및 창 이동기능 구현
		menuBar.setBounds(0, 0, 1280, 30);
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
		
		songSelectScreen.setBounds(0, 0, 1280, 720);
		songSelectScreen.addKeyListener (new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				if (KeyCode == KeyEvent.VK_ENTER)
					System.exit(0);
			}
//			public boolean isAltDown() {
//				public keyPressed(KeyEvent e) {
//					int KeyCode = e.getKeyCode();
//					if (KeyCode == KeyEvent.VK_ENTER)
//						setExtendedState(JFrame.MAXIMIZED_BOTH);
//				}
//			}
		});
		add(songSelectScreen);

		// start버튼의 화면 설정 및 여러 마우스 기능 구현
		startButton.setBounds(560, 465, 150, 80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false);
				optionButton.setVisible(false);
				exitButton.setVisible(false);
				isMainScreen = true;
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
			}
		});
		add(startButton);

		// option버튼의 화면 설정 및 여러 마우스 기능 구현
		optionButton.setBounds(510, 540, 250, 90);
		optionButton.setBorderPainted(false);
		optionButton.setContentAreaFilled(false);
		optionButton.setFocusPainted(false);
		optionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				optionButton.setIcon(optionButtonEnteredImage);
				optionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				optionButton.setIcon(optionButtonBasicImage);
				optionButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false);
				optionButton.setVisible(false);
				exitButton.setVisible(false);
				isOptionScreen = true;
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
			}
		});
		add(optionButton);

		// exit버튼의 화면 설정 및 여러 마우스 기능 구현
		exitButton.setBounds(560, 627, 150, 80);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		add(exitButton);
		
		previousButton.setVisible(false);
		previousButton.setBounds(20, 10, 230, 70);
		previousButton.setBorderPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setFocusPainted(false);
		previousButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				previousButton.setIcon(previousButtonEnteredImage);
				previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				previousButton.setIcon(previousButtonBasicImage);
				previousButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				isMainScreen = false;
				isOptionScreen = false;
				startButton.setVisible(true);
				optionButton.setVisible(true);
				exitButton.setVisible(true);
				previousButton.setVisible(false);
			}
		});

		add(previousButton);

		// UI가 나온 후, 음악이 재생
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
//		if (isMainScreen);
//		{
//			introMusic.interrupt();
//			Music SelectMusic = new Music("InTheBlueShirt_ClusterA(Fusq_Remix).mp3",true);
//		}
		/* 위 아래 방향키버튼을 이용해서 노래를 선택하면 그 노래가 나오도록 설정할 예정.
		 * if (keyBoardPreesed); {
		 * 
		 * }
		 */

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	// 배경화면을 기본으로 띄워주고, 메인화면(곡 선택화면)에 있다면 그 곡의 썸네일도 띄워줌
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(Title, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage, 50, 120, null);
			previousButton.setVisible(true);
			
		}
		if (isOptionScreen) {
			g.drawImage(selectedImage, 50, 120, null);
			previousButton.setVisible(true);
		}
		paintComponents(g);
		this.repaint();
	}

}
