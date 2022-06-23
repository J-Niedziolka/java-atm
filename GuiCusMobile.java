package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GuiCusMobile extends Okno implements ActionListener {
	private JLabel lInf, lOperator, lkwota;
	private JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
	private ButtonGroup group1, group2;
	private JButton bRefill, bClose, bReturn;
	private int index;
	private String pin;

	public GuiCusMobile(int index, String pin) {
		this.index = index;
		this.pin = pin;
		lInf = new JLabel("Dładowanie telefonu: ");
		lInf.setBounds(200, 20, 300, 40);
		lInf.setFont(font2);
		midPanel.add(lInf);

		lOperator = new JLabel("Wybierz operatora: ");
		lOperator.setBounds(50, 100, 300, 40);
		lOperator.setFont(font2);
		midPanel.add(lOperator);

		r1 = new JRadioButton("Orange");
		r1.setBounds(50, 150, 120, 40);
		r1.setFont(font2);
		r1.setBackground(Color.yellow);

		r2 = new JRadioButton("Plus");
		r2.setBounds(170, 150, 120, 40);
		r2.setFont(font2);
		r2.setBackground(Color.yellow);

		r3 = new JRadioButton("T-Mobile");
		r3.setBounds(290, 150, 120, 40);
		r3.setFont(font2);
		r3.setBackground(Color.yellow);

		r4 = new JRadioButton("Play");
		r4.setBounds(410, 150, 120, 40);
		r4.setFont(font2);
		r4.setBackground(Color.yellow);

		group1 = new ButtonGroup();
		group1.add(r1);
		group1.add(r2);
		group1.add(r3);
		group1.add(r4);
		midPanel.add(r1);
		midPanel.add(r2);
		midPanel.add(r3);
		midPanel.add(r4);

		lkwota = new JLabel("Wybierz kwotę doładowania: ");
		lkwota.setFont(font2);
		lkwota.setBounds(50, 200, 300, 40);
		midPanel.add(lkwota);

		r5 = new JRadioButton("10 PLN");
		r5.setBounds(50, 250, 120, 40);
		r5.setFont(font2);
		r5.setBackground(Color.yellow);

		r6 = new JRadioButton("25 PLN");
		r6.setBounds(170, 250, 120, 40);
		r6.setFont(font2);
		r6.setBackground(Color.yellow);

		r7 = new JRadioButton("50 PLN");
		r7.setBounds(290, 250, 120, 40);
		r7.setFont(font2);
		r7.setBackground(Color.yellow);

		r8 = new JRadioButton("100 PLN");
		r8.setBounds(410, 250, 120, 40);
		r8.setFont(font2);
		r8.setBackground(Color.yellow);

		group2 = new ButtonGroup();
		group2.add(r5);
		group2.add(r6);
		group2.add(r7);
		group2.add(r8);
		midPanel.add(r5);
		midPanel.add(r6);
		midPanel.add(r7);
		midPanel.add(r8);

		bRefill = new JButton("Daładuj");
		bRefill.setBounds(250, 350, 100, 50);
		midPanel.add(bRefill);

		bClose = new JButton("Zamknij");
		bClose.setBounds(0, 550, 100, 50);
		midPanel.add(bClose);
		
		bReturn = new JButton("Powrót");
		bReturn.setBounds(500, 550, 100, 50);
		midPanel.add(bReturn);

		bClose.addActionListener(this);
		bRefill.addActionListener(this);
		bReturn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bReturn) {
			dispose();
			GuiCusMenu cusLogin = new GuiCusMenu(index, pin);
			cusLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cusLogin.setVisible(true);
		} else if (source == bRefill) {
			if ((r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected())
					&& (r5.isSelected() || r6.isSelected() || r7.isSelected() || r8.isSelected())) {
				float kwota;
				if (r5.isSelected())
					kwota = 10;
				else if (r6.isSelected())
					kwota = 25;
				else if (r7.isSelected())
					kwota = 50;
				else
					kwota = 100;
				
				try {
					zapisz(kwota);
				} catch (IOException exception) {
					exception.printStackTrace();
				} catch (ClassNotFoundException exception) {
					JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Doładowywanie telefonu", JOptionPane.INFORMATION_MESSAGE);
					exception.printStackTrace();
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Doładowywanie telefonu", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Nieprawidłowa kwota");
				}
			} 
		} else if (source == bClose) {
			dispose();
		}
	}

	public void zapisz(float kwota) throws IOException, ClassNotFoundException {
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
			if (arr[index].getSrodki() >= kwota) {
				arr[this.index].setSrodki(arr[this.index].getSrodki() - kwota);
				JOptionPane.showMessageDialog(null, "Doładowano telefon", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Niewystarczająca ilość środków", "Wynik",
						JOptionPane.INFORMATION_MESSAGE);
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
			System.out.println("OknoDoladTele\\zapisz\\IoException");
		}
	}
}
