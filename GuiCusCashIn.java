package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GuiCusCashIn extends Okno2 implements ActionListener, IBankomat{
	private JLabel lSuma;
	private JTextField tf500, tf200, tf100, tf50, tf20, tf10;
	private JButton bWplac, bSuma;//, bClose, bReturn;
	private Bankomat bankomat;
	private int karta;
	private String pin;

	public GuiCusCashIn(int karta, String pin) {
		this.pin = pin;
		this.karta = karta;
		JLabel lInf = new JLabel("Wprowadzanie banknotów: ");
		lInf.setBounds(200, 20, 300, 40);
		lInf.setFont(font2);
		midPanel.add(lInf);

		tf500 = new JTextField("0");
		tf500.setBounds(350, 100, 150, 40);
		midPanel.add(tf500);

		tf200 = new JTextField("0");
		tf200.setBounds(350, 150, 150, 40);
		midPanel.add(tf200);

		tf100 = new JTextField("0");
		tf100.setBounds(350, 200, 150, 40);
		midPanel.add(tf100);

		tf50 = new JTextField("0");
		tf50.setBounds(350, 250, 150, 40);
		midPanel.add(tf50);

		tf20 = new JTextField("0");
		tf20.setBounds(350, 300, 150, 40);
		midPanel.add(tf20);

		tf10 = new JTextField("0");
		tf10.setBounds(350, 350, 150, 40);
		midPanel.add(tf10);

		lSuma = new JLabel("");
		lSuma.setBounds(375, 450, 225, 50);
		lSuma.setFont(font2);
		midPanel.add(lSuma);

		bSuma = new JButton("Sumuj");
		bSuma.setBounds(250, 400, 100, 50);
		midPanel.add(bSuma);

		bWplac = new JButton("Wpłać");
		bWplac.setBounds(250, 500, 100, 50);
		midPanel.add(bWplac);
		
		/*bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);
		
		bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);
*/
		bClose.addActionListener(this);
		bReturn.addActionListener(this);
		bWplac.addActionListener(this);
		bSuma.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bReturn) {
			dispose();
			GuiCusMenu oknoMenuKlienta = new GuiCusMenu(karta, pin);
			oknoMenuKlienta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			oknoMenuKlienta.setVisible(true);
		} else if (source == bWplac) {
			String s500 = tf500.getText();
			String s200 = tf200.getText();
			String s100 = tf100.getText();
			String s50 = tf50.getText();
			String s20 = tf20.getText();
			String s10 = tf10.getText();
			try {
				int i500 = Integer.parseInt(s500);
				int i200 = Integer.parseInt(s200);
				int i100 = Integer.parseInt(s100);
				int i50 = Integer.parseInt(s50);
				int i20 = Integer.parseInt(s20);
				int i10 = Integer.parseInt(s10);
				
				int suma = i500 * 500 + i200 * 200 + i100 * 100 + i50 * 50 + i20 * 20 + i10 * 10;
				int kwota = Integer.parseInt(String.valueOf(suma));
				zapisz(kwota, i500, i200, i100, i50, i20, i10);
				
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
				JOptionPane.showMessageDialog(null, "Dokonano wpłaty", "Wpłata", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wpłata", JOptionPane.INFORMATION_MESSAGE);
				exception.printStackTrace();
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wpłata", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Nieprawidłowa kwota");
			}
		} else if (source == bSuma) {
			suma();
		} else if (source == bClose) {
			dispose();
		}
	}

	public void suma() {
		String s500 = tf500.getText();
		String s200 = tf200.getText();
		String s100 = tf100.getText();
		String s50 = tf50.getText();
		String s20 = tf20.getText();
		String s10 = tf10.getText();
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
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Sumowanie", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Nieprawidłowa kwota");
		}
	}

	public void zapisz(int kwota, int i500, int i200, int i100, int i50, int i20, int i10) throws IOException, ClassNotFoundException {
		Klient[] arr = new Klient[100];
		ObjectInputStream ois = null;
		int count = 0;
		try {
			ois = new ObjectInputStream(new FileInputStream("klient.txt"));

			while (true) {
				arr[count] = (Klient) ois.readObject();
				count++;
			}
		} catch (EOFException ex) {
			if (ois != null)
				ois.close();

			ObjectOutputStream oos = null;
			arr[this.karta].setSrodki(arr[this.karta].getSrodki() + kwota);
			Bankomat bankomat = new Bankomat();
			bankomat.IWplata(arr[this.karta], kwota, i500, i200, i100, i50, i20, i10);
			try {
				oos = new ObjectOutputStream(new FileOutputStream("klient.txt"));
				for (int i = 0; arr[i] != null; i++) {
					oos.writeObject(arr[i]);
				}
				oos.flush();
			} finally {
				if (oos != null)
					oos.close();
			}
		} catch (IOException e) {
			System.out.println("OknoWplata\\zapisz\\IoException");
		}
	}
}
