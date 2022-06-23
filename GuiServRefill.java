package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiServRefill extends Okno2 implements ActionListener, IBankomat {
	private JLabel lMain, lSesja, lSuma;
	private JTextField t500, t200, t100, t50, t20, t10;
	private JButton bDodaj, bSuma;
	private Bankomat bankomat;

	public GuiServRefill() {
		setTitle("Uzupełnianie środków");

		lSesja = new JLabel("Sesja pracownicza");
		lSesja.setForeground(Color.red);
		lSesja.setBounds(0, 0, 300, 50);
		lSesja.setFont(font2);
		topPanel.add(lSesja);

		lMain = new JLabel("Uzupełnianie bankomatu: ");
		lMain.setBounds(100, 20, 500, 40);
		lMain.setFont(font2);
		midPanel.add(lMain);

		t500 = new JTextField("0");
		t500.setBounds(350, 100, 150, 40);
		midPanel.add(t500);

		t200 = new JTextField("0");
		t200.setBounds(350, 150, 150, 40);
		midPanel.add(t200);

		t100 = new JTextField("0");
		t100.setBounds(350, 200, 150, 40);
		midPanel.add(t100);

		t50 = new JTextField("0");
		t50.setBounds(350, 250, 150, 40);
		midPanel.add(t50);

		t20 = new JTextField("0");
		t20.setBounds(350, 300, 150, 40);
		midPanel.add(t20);

		t10 = new JTextField("0");
		t10.setBounds(350, 350, 150, 40);
		midPanel.add(t10);

		lSuma = new JLabel("");
		lSuma.setBounds(375, 450, 225, 50);
		lSuma.setFont(font2);
		midPanel.add(lSuma);

		bSuma = new JButton("Sumuj");
		bSuma.setBounds(250, 400, 100, 50);
		midPanel.add(bSuma);

		bDodaj = new JButton("Dodaj");
		bDodaj.setBounds(250, 500, 100, 50);
		midPanel.add(bDodaj);

		bReturn.addActionListener(this);
		bDodaj.addActionListener(this);
		bSuma.addActionListener(this);
		bClose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bReturn) {
			dispose();
			GuiServMenu service = new GuiServMenu();
			service.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			service.setVisible(true);
		} else if (source == bDodaj) {
			String s500 = t500.getText();
			String s200 = t200.getText();
			String s100 = t100.getText();
			String s50 = t50.getText();
			String s20 = t20.getText();
			String s10 = t10.getText();
			try {
				int i500 = Integer.parseInt(s500);
				int i200 = Integer.parseInt(s200);
				int i100 = Integer.parseInt(s100);
				int i50 = Integer.parseInt(s50);
				int i20 = Integer.parseInt(s20);
				int i10 = Integer.parseInt(s10);
				//int suma = i500 * 500 + i200 * 200 + i100 * 100 + i50 * 50 + i20 * 20 + i10 * 10;
				this.bankomat = new Bankomat();
				this.bankomat.fromFile();
				this.bankomat.set500(bankomat.get500() + i500);
				this.bankomat.set200(bankomat.get200() + i200);
				this.bankomat.set100(bankomat.get100() + i100);
				this.bankomat.set50(bankomat.get50() + i50);
				this.bankomat.set20(bankomat.get20() + i20);
				this.bankomat.set10(bankomat.get10() + i10);
				this.bankomat.setSuma();
				this.bankomat.toFile();

				JOptionPane.showMessageDialog(null, "Dodano", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidlowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
				exception.printStackTrace();
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidlowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (source == bSuma) {
			suma();
		} else if (source == bClose) {
			dispose();
		}
	}

	public void suma() {
		String s500 = t500.getText();
		String s200 = t200.getText();
		String s100 = t100.getText();
		String s50 = t50.getText();
		String s20 = t20.getText();
		String s10 = t10.getText();
		try {
			int i500 = Integer.parseInt(s500);
			int i200 = Integer.parseInt(s200);
			int i100 = Integer.parseInt(s100);
			int i50 = Integer.parseInt(s50);
			int i20 = Integer.parseInt(s20);
			int i10 = Integer.parseInt(s10);
			int suma = i500 * 500 + i200 * 200 + i100 * 100 + i50 * 50 + i20 * 20 + i10 * 10;
			lSuma.setText(String.valueOf(suma));

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidloowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
