package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GuiCusCashOut extends Okno implements ActionListener, IBankomat{
	private JLabel label1, label2;
	private JTextField tfwyplata;
	private JButton bWyplac, bReturn, bClose;
	private int karta;
	private String pin;

	public GuiCusCashOut(int karta, String pin) {
		this.pin = pin;
		this.karta = karta;
		label1 = new JLabel("Wypłata: ");
		label1.setBounds(250, 50, 250, 40);
		label1.setFont(font2);
		midPanel.add(label1);

		label2 = new JLabel("Wprowadź kwotę: ");
		label2.setBounds(100, 250, 250, 40);
		label2.setFont(font2);
		midPanel.add(label2);

		tfwyplata = new JTextField("");
		tfwyplata.setBounds(350, 250, 150, 40);
		midPanel.add(tfwyplata);

		bWyplac = new JButton("Wypłać");
		bWyplac.setBounds(250, 400, 100, 50);
		midPanel.add(bWyplac);

		bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);
		
		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);

		bWyplac.addActionListener(this);
		bReturn.addActionListener(this);
		bClose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bWyplac) {
			String s1 = tfwyplata.getText();
			try {
				int kwotaInt = Integer.parseInt(s1);
				if (kwotaInt % 10 == 0) {
					int kwotaFloat = Integer.parseInt(s1);
					zapisz(kwotaFloat);
				} else {
					JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowa kwota", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
				exception.printStackTrace();
			}
		} else if (source == bReturn) {
			dispose();
			GuiCusMenu oknoMenuKlienta = new GuiCusMenu(karta, pin);
			oknoMenuKlienta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			oknoMenuKlienta.setVisible(true);
		} else if (source == bClose) {
			dispose();
		}
	}

	public void zapisz(int kwota) throws IOException, ClassNotFoundException {
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
			try {
				Bankomat bankomat = new Bankomat();
				bankomat.fromFile();

				if ((arr[this.karta].getSrodki() >= kwota) && (bankomat.getSuma() >= kwota)) {
					//tutaj dodac zmienianie sie liczby banknotow w bankomacie
					arr[this.karta].setSrodki(arr[this.karta].getSrodki() - kwota);
					bankomat.IWyplata(arr[this.karta], kwota);
				}

			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Nieprawidłowa kwota");
			}

			ObjectOutputStream oos = null;
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
			System.out.println("OknoWyplata//zapisz//IoException");
		}
	}

}
