package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiServCash extends Okno2 implements ActionListener {
	private JLabel lInf, l500, l200, l100, l50, l20, l10, lSuma, lSesja;
	private Bankomat bankomat;
	private String s1;

	public GuiServCash() throws IOException, ClassNotFoundException {
		this.bankomat = new Bankomat();
		try {
			bankomat.fromFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			exception.printStackTrace();
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
		}
		lSesja = new JLabel("Sesja pracownicza");
		lSesja.setForeground(Color.red);
		lSesja.setBounds(0, 0, 300, 50);
		lSesja.setFont(font2);
		topPanel.add(lSesja);
		
		lInf = new JLabel("Liczba poszczególnych nominałów w bankomacie: ");
		lInf.setBounds(0, 20, 600, 40);
		lInf.setFont(font2);
		midPanel.add(lInf);

		s1 = String.valueOf(bankomat.get500());
		l500 = new JLabel(s1);
		l500.setBounds(350, 100, 150, 50);
		l500.setFont(font2);
		midPanel.add(l500);

		s1 = String.valueOf(bankomat.get200());
		l200 = new JLabel(s1);
		l200.setBounds(350, 150, 150, 50);
		l200.setFont(font2);
		midPanel.add(l200);

		s1 = String.valueOf(bankomat.get100());
		l100 = new JLabel(s1);
		l100.setBounds(350, 200, 150, 50);
		l100.setFont(font2);
		midPanel.add(l100);

		s1 = String.valueOf(bankomat.get50());
		l50 = new JLabel(s1);
		l50.setBounds(350, 250, 150, 50);
		l50.setFont(font2);
		midPanel.add(l50);

		s1 = String.valueOf(bankomat.get20());
		l20 = new JLabel(s1);
		l20.setBounds(350, 300, 150, 50);
		l20.setFont(font2);
		midPanel.add(l20);

		s1 = String.valueOf(bankomat.get10());
		l10 = new JLabel(s1);
		l10.setBounds(350, 350, 150, 50);
		l10.setFont(font2);
		midPanel.add(l10);

		s1 = String.valueOf(bankomat.getSuma());
		lSuma = new JLabel(s1);
		lSuma.setBounds(375, 450, 150, 50);
		lSuma.setFont(font2);
		midPanel.add(lSuma);

		bClose.addActionListener(this);
		bReturn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if (zrodlo == bReturn) {
			dispose();
			GuiServMenu oknoMenuPracownika = new GuiServMenu();
			oknoMenuPracownika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			oknoMenuPracownika.setVisible(true);
		} else if (zrodlo == bClose) {
			dispose();
		}
	}
}