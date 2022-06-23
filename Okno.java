package atm_final2;

import javax.swing.*;
import java.awt.*;

public abstract class Okno extends Bankomat {
	protected JPanel midPanel, topPanel;
	protected JLabel label1;
	static final Font font1 = new Font("Monospaced", Font.BOLD, 35);
	static final Font font2 = new Font("Monospaced", Font.PLAIN, 25);
	static final String title = "Bankomat UPH";
	
	public Okno() {
		setSize(860, 840);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 860, 840);
		topPanel.setBackground(Color.GRAY);
		topPanel.setLayout(new BorderLayout());
		topPanel.setLayout(null);
		label1 = new JLabel(title);
		label1.setBounds(300, 50, 400, 40);
		label1.setFont(font1);
		topPanel.add(label1);

		midPanel = new JPanel();
		midPanel.setLayout(new BorderLayout());
		midPanel.setLayout(null);
		midPanel.setBounds(100, 100, 600, 600);
		midPanel.setBackground(Color.LIGHT_GRAY);
		
		topPanel.add(midPanel);
		add(topPanel);
	}
}

