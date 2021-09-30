package mainGame;


import javax.swing.JFrame;


public class MainWindow extends JFrame {
	public static final int WIDTH=800;
	private Gameplay gameplay;

	
	public MainWindow() {
		super("Run Saitama, Run!");
		setSize(WIDTH, 500);
		setLocation(200,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameplay=new Gameplay();
		addKeyListener(gameplay);
		add(gameplay);

	}
	public void start() {
		setVisible(true);
		gameplay.start();
	}

	public static void main(String[] args) {
		(new MainWindow()).start();
	}

}
