package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GuiCusMenu extends Okno implements ActionListener, IBankomat {
	private JLabel lDane, lImie1, lNazwisko1, lBanl1, lNrKarty1, lSrodki1, lImie2, lNazwisko2, lBank2, lNrKarty2,
			lSrodki2;
	private JButton bReturn, bClose, bWplata, bWyplata, bDoladowanie;
	private Object[][] tab;
	private int index;
	private String pin;

	public GuiCusMenu(int index, String pin) {
		this.index = index;
		this.pin = pin;
		setTitle("Menu Klienta");

		try {
			odczyt();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			exception.printStackTrace();
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
		}

		lDane = new JLabel("Dane właściciela: ");
		lDane.setBounds(50, 80, 300, 50);
		lDane.setFont(font2);
		midPanel.add(lDane);

		lImie1 = new JLabel("Imie: ");
		lImie1.setBounds(50, 150, 200, 40);
		lImie1.setFont(font2);
		midPanel.add(lImie1);

		String s1 = String.valueOf(tab[this.index][0]);
		lImie2 = new JLabel(s1);
		lImie2.setBounds(250, 150, 200, 40);
		lImie2.setFont(font2);
		midPanel.add(lImie2);

		lNazwisko1 = new JLabel("Nazwisko: ");
		lNazwisko1.setBounds(50, 200, 200, 40);
		lNazwisko1.setFont(font2);
		midPanel.add(lNazwisko1);

		s1 = String.valueOf(tab[this.index][1]);
		lNazwisko2 = new JLabel(s1);
		lNazwisko2.setBounds(250, 200, 200, 40);
		lNazwisko2.setFont(font2);
		midPanel.add(lNazwisko2);

		lBanl1 = new JLabel("Bank: ");
		lBanl1.setBounds(50, 250, 200, 40);
		lBanl1.setFont(font2);
		midPanel.add(lBanl1);

		s1 = String.valueOf(tab[this.index][2]);
		lBank2 = new JLabel(s1);
		lBank2.setBounds(250, 250, 200, 40);
		lBank2.setFont(font2);
		midPanel.add(lBank2);

		lNrKarty1 = new JLabel("Nr karty: ");
		lNrKarty1.setBounds(50, 300, 200, 40);
		lNrKarty1.setFont(font2);
		midPanel.add(lNrKarty1);

		s1 = String.valueOf(tab[this.index][3]);
		lNrKarty2 = new JLabel(s1);
		lNrKarty2.setBounds(250, 300, 200, 40);
		lNrKarty2.setFont(font2);
		midPanel.add(lNrKarty2);

		lSrodki1 = new JLabel("Środki: ");
		lSrodki1.setBounds(50, 350, 200, 40);
		lSrodki1.setFont(font2);
		midPanel.add(lSrodki1);

		s1 = String.valueOf(tab[this.index][5]);
		lSrodki2 = new JLabel(s1);
		lSrodki2.setBounds(250, 350, 200, 40);
		lSrodki2.setFont(font2);
		midPanel.add(lSrodki2);

		bReturn = new JButton("Cofnij");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);
		
		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);

		bWplata = new JButton("Wpłata gotówki");
		bWplata.setBounds(20, 400, 280, 50);
		midPanel.add(bWplata);

		bWyplata = new JButton("Wypłata gotówki");
		bWyplata.setBounds(20, 460, 280, 50);
		midPanel.add(bWyplata);

		bDoladowanie = new JButton("Doładowanie telefonu");
		bDoladowanie.setBounds(310, 460, 280, 50);
		midPanel.add(bDoladowanie);

		bReturn.addActionListener(this);
		bWplata.addActionListener(this);
		bWyplata.addActionListener(this);
		bClose.addActionListener(this);
		bDoladowanie.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bReturn) {
			dispose();
			GuiCusLog customerLogin = new GuiCusLog();
			customerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			customerLogin.setVisible(true);
		} else if (source == bClose) {
			dispose();
		} else if (source == bWplata) {
			dispose();
			GuiCusCashIn cashIn = new GuiCusCashIn(index, pin);
			cashIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cashIn.setVisible(true);
		} else if (source == bWyplata) {
			dispose();
			GuiCusCashOut cashOut = new GuiCusCashOut(index, pin);
			cashOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cashOut.setVisible(true);

		}
		else if (source == bDoladowanie) {
			GuiCusMobile mobile = new GuiCusMobile(index, pin);
			mobile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mobile.setVisible(true);
		}

	}

	public void odczyt() throws IOException, ClassNotFoundException {
		Object[][] arr = new Object[50][7];
		ObjectInputStream ois = null;
		Klient cus = null;
		int count = 0;
		try {
			ois = new ObjectInputStream(new FileInputStream("klient.txt"));
			while (true) {
				cus = (Klient) ois.readObject();
				arr[count][0] = cus.getImie();
				arr[count][1] = cus.getNazwisko();
				arr[count][2] = cus.getBank();
				arr[count][3] = cus.getNrKarty();
				arr[count][4] = cus.getPin();
				arr[count][5] = cus.getSrodki();
				arr[count][6] = cus.getTele();
				count++;
			}
		} catch (EOFException ex) {
		} finally {
			if (ois != null)
				ois.close();
		}
		setTab(arr);
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void setTab(Object[][] tab) {
		this.tab = tab;
	}

}