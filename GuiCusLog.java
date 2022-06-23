package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GuiCusLog extends Okno implements ActionListener {
	private JButton bEnter, bClose, bReturn, bCancel, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JLabel lNrKarty, lPin;
	private JTextField tNrKarty;
	private JPasswordField pPin;
	private JRadioButton r1, r2;
	private ButtonGroup group;
	private String nrKarty = "", pin = "";
	private Object[][] tab;
	private int ile, index;

	public GuiCusLog() {
		setTitle("Logowanie");

		try {
			readFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Klient logowanie", JOptionPane.INFORMATION_MESSAGE);
			exception.printStackTrace();
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Klient logowanie3", JOptionPane.INFORMATION_MESSAGE);
		}

		lNrKarty = new JLabel("Numer karty: ");
		lNrKarty.setBounds(50, 100, 200, 40);
		lNrKarty.setFont(font2);
		midPanel.add(lNrKarty);

		tNrKarty = new JTextField("");
		tNrKarty.setBounds(250, 100, 200, 40);
		midPanel.add(tNrKarty);

		lPin = new JLabel("Pin: ");
		lPin.setBounds(50, 200, 100, 40);
		lPin.setFont(font2);
		midPanel.add(lPin);

		pPin = new JPasswordField("");
		pPin.setBounds(250, 200, 100, 40);
		midPanel.add(pPin);

		b1 = new JButton("1");
		b1.setBounds(225, 350, 50, 50);
		midPanel.add(b1);
		b2 = new JButton("2");
		b2.setBounds(275, 350, 50, 50);
		midPanel.add(b2);
		b3 = new JButton("3");
		b3.setBounds(325, 350, 50, 50);
		midPanel.add(b3);
		b4 = new JButton("4");
		b4.setBounds(225, 400, 50, 50);
		midPanel.add(b4);
		b5 = new JButton("5");
		b5.setBounds(275, 400, 50, 50);
		midPanel.add(b5);
		b6 = new JButton("6");
		b6.setBounds(325, 400, 50, 50);
		midPanel.add(b6);
		b7 = new JButton("7");
		b7.setBounds(225, 450, 50, 50);
		midPanel.add(b7);
		b8 = new JButton("8");
		b8.setBounds(275, 450, 50, 50);
		midPanel.add(b8);
		b9 = new JButton("9");
		b9.setBounds(325, 450, 50, 50);
		midPanel.add(b9);
		b0 = new JButton("0");
		b0.setBounds(275, 500, 50, 50);
		midPanel.add(b0);
		bEnter = new JButton("Enter");
		bEnter.setBounds(325, 500, 100, 50);
		midPanel.add(bEnter);
		bCancel = new JButton("Cofnij");
		bCancel.setBounds(175, 500, 100, 50);
		midPanel.add(bCancel);
		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);
		bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);
		r1 = new JRadioButton("nr karty");
		r2 = new JRadioButton("pin");
		r1.setBounds(450, 350, 80, 20);
		r2.setBounds(450, 400, 80, 20);
		r1.setBackground(Color.LIGHT_GRAY);
		r2.setBackground(Color.LIGHT_GRAY);
		group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		midPanel.add(r1);
		midPanel.add(r2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bEnter.addActionListener(this);
		bCancel.addActionListener(this);
		bClose.addActionListener(this);
		bReturn.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == b1) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "1";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "1";
				pPin.setText(pin);
			}
		} else if (source == b2) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "2";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "2";
				pPin.setText(pin);
			}
		} else if (source == b3) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "3";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "3";
				pPin.setText(pin);
			}
		} else if (source == b4) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "4";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "4";
				pPin.setText(pin);
			}
		} else if (source == b5) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "5";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "5";
				pPin.setText(pin);
			}
		} else if (source == b6) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "6";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "6";
				pPin.setText(pin);
			}
		} else if (source == b7) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "7";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "7";
				pPin.setText(pin);
			}
		} else if (source == b8) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "8";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "8";
				pPin.setText(pin);
			}
		} else if (source == b9) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "9";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "9";
				pPin.setText(pin);
			}
		} else if (source == b0) {
			if (r1.isSelected()) {
				nrKarty = nrKarty + "0";
				tNrKarty.setText(nrKarty);
			} else if (r2.isSelected()) {
				pin = pin + "0";
				pPin.setText(pin);
			}
		} else if (source == bCancel) {
			if (r1.isSelected()) {
				if (nrKarty.length() > 0) {
					String pom = "";
					for (int i = 0; i < nrKarty.length() - 1; i++) {
						pom = pom + nrKarty.charAt(i);
					}
					nrKarty = pom;
					tNrKarty.setText(nrKarty);
				}
			} else if (r2.isSelected()) {
				if (pin.length() > 0) {
					String pom = "";
					for (int i = 0; i < pin.length() - 1; i++) {
						pom = pom + pin.charAt(i);
					}
					pin = pom;
					pPin.setText(pin);
				}
			}
		} else if (source == bEnter) {
			try {
				readFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
				exception.printStackTrace();
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			}
			if (weryfikacja()) {
				System.out.println(pin + " Po weryfikacji");
				dispose();
				GuiCusMenu cusMenu = new GuiCusMenu(index, pin);
				cusMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				cusMenu.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (source == bReturn) {
			dispose();
			GuiEntry entry = new GuiEntry();
			entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			entry.setVisible(true);
		} else if (source == bClose) {
			dispose();
		}
	}

	public void readFile() throws IOException, ClassNotFoundException {
		Object[][] obj = new Object[50][7];
		ObjectInputStream ois = null;
		Klient cus = null;
		int count = 0;
		try {
			ois = new ObjectInputStream(new FileInputStream("klient.txt"));
			while (true) {
				cus = (Klient) ois.readObject();
				obj[count][0] = cus.getImie();
				obj[count][1] = cus.getNazwisko();
				obj[count][2] = cus.getBank();
				obj[count][3] = cus.getNrKarty();
				obj[count][4] = cus.getPin();
				obj[count][5] = cus.getSrodki();
				obj[count][6] = cus.getTele();
				count++;
			}
		} catch (EOFException ex) {
		} finally {
			if (ois != null)
				ois.close();
		}
		setTab(obj);
		setIle(count);

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void setTab(Object[][] tab) {
		this.tab = tab;
	}

	public void setIle(int ile) {
		this.ile = ile;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean weryfikacja() {
		String nrkarty = tNrKarty.getText();
		String pin = pPin.getText();
		for (int i = 0; i < ile; i++) {
			if ((tab[i][3].equals(nrkarty)) && (tab[i][4].equals(pin))) {
				setIndex(i);
				setPin(pin);
				return true;
			}
		}
		return false;
	}
}