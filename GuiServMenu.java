package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiServMenu extends Okno implements ActionListener {
	private JButton bAddCus, bCash, bRefill, bClose, bReturn;
	private JLabel lSesja;

	public GuiServMenu() {
		setTitle("Sesja Pracownicza");

		lSesja = new JLabel("Sesja pracownicza");
		lSesja.setForeground(Color.red);
		lSesja.setBounds(0, 0, 300, 50);
		lSesja.setFont(font2);
		topPanel.add(lSesja);

		bAddCus = new JButton("Dodaj nowego klienta");
		bAddCus.setBounds(175, 150, 275, 50);
		midPanel.add(bAddCus);

		bCash = new JButton("Wyświetl zawartość bankomatu");
		bCash.setBounds(175, 250, 275, 50);
		midPanel.add(bCash);

		bRefill = new JButton("Uzupełnij bankomat");
		bRefill.setBounds(175, 350, 275, 50);
		midPanel.add(bRefill);

		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);
		
		bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);

		bAddCus.addActionListener(this);
		bClose.addActionListener(this);
		bCash.addActionListener(this);
		bReturn.addActionListener(this);
		bRefill.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bAddCus) {
			dispose();
			GuiServAdd addCus = new GuiServAdd();
			addCus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addCus.setVisible(true);
		} else if (source == bReturn) {
			dispose();
			GuiServLog serviceLogin = new GuiServLog();
			serviceLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			serviceLogin.setVisible(true);
		} else if (source == bCash) {
			dispose();
			GuiServCash checkCash = null;
			try {
				checkCash = new GuiServCash();
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				exception.printStackTrace();
			}
			checkCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			checkCash.setVisible(true);
		} else if (source == bRefill) {
			dispose();
			GuiServRefill refill = new GuiServRefill();
			refill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			refill.setVisible(true);
		} else if (source == bClose) {
			dispose();
		}
	}
}
