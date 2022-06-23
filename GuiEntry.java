package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiEntry extends Okno implements ActionListener {
	private JButton bService, bCustomer, bClose; //bReturn;
	private JLabel label;

	public GuiEntry() {
		label = new JLabel("Wybór użytkownika");
		label.setBounds(175, 100, 300, 50);
		label.setFont(font2);
		midPanel.add(label);

		bService = new JButton("Pracownik");
		bService.setBounds(175, 300, 300, 50);
		midPanel.add(bService);

		bCustomer = new JButton("Klient");
		bCustomer.setBounds(175, 400, 300, 50);
		midPanel.add(bCustomer);

		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);
		
		/*bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);*/

		bService.addActionListener(this);
		bCustomer.addActionListener(this);
		bClose.addActionListener(this);
		//bReturn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == bService) {
			dispose();
			GuiServLog serviceLogin = new GuiServLog();
			serviceLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			serviceLogin.setVisible(true);
		} else if (src == bCustomer) {
			dispose();
			GuiCusLog customerLogin = new GuiCusLog();
			customerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			customerLogin.setVisible(true);
		} else if (src == bClose) {
			dispose();
		}
	}
}