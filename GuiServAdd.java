package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class GuiServAdd extends Okno implements ActionListener {
	private JLabel lSesja, lImie, lNazwisko, lBank, lNrKarty, lPin, lKwota, lTele;
	private JTextField tfImie, tfNazwisko, tfBank, tfNrKarty, tfPin, tfKwota, tfTele;
	private JButton bSave, bClose, bReturn;

	public GuiServAdd() {
		lSesja = new JLabel("Sesja pracownicza");
		lSesja.setForeground(Color.red);
		lSesja.setBounds(0, 0, 300, 50);
		lSesja.setFont(font2);
		topPanel.add(lSesja);

		lImie = new JLabel("Imie:");
		lImie.setBounds(100, 100, 150, 40);
		lImie.setFont(font2);
		midPanel.add(lImie);

		tfImie = new JTextField("");
		tfImie.setBounds(300, 100, 150, 40);
		midPanel.add(tfImie);

		lNazwisko = new JLabel("Nazwisko:");
		lNazwisko.setBounds(100, 150, 150, 40);
		lNazwisko.setFont(font2);
		midPanel.add(lNazwisko);

		tfNazwisko = new JTextField("");
		tfNazwisko.setBounds(300, 150, 150, 40);
		midPanel.add(tfNazwisko);

		lBank = new JLabel("Bank:");
		lBank.setBounds(100, 200, 150, 40);
		lBank.setFont(font2);
		midPanel.add(lBank);

		tfBank = new JTextField("");
		tfBank.setBounds(300, 200, 150, 40);
		midPanel.add(tfBank);

		lNrKarty = new JLabel("Nr karty:");
		lNrKarty.setBounds(100, 250, 150, 40);
		lNrKarty.setFont(font2);
		midPanel.add(lNrKarty);

		tfNrKarty = new JTextField("");
		tfNrKarty.setBounds(300, 250, 150, 40);
		midPanel.add(tfNrKarty);

		lPin = new JLabel("Pin:");
		lPin.setBounds(100, 300, 150, 40);
		lPin.setFont(font2);
		midPanel.add(lPin);

		tfPin = new JTextField("");
		tfPin.setBounds(300, 300, 150, 40);
		midPanel.add(tfPin);

		lTele = new JLabel("Tele:");
		lTele.setBounds(100, 350, 150, 40);
		lTele.setFont(font2);
		midPanel.add(lTele);

		tfTele = new JTextField("");
		tfTele.setBounds(300, 350, 150, 40);
		midPanel.add(tfTele);
		
		lKwota = new JLabel("Kwota:");
		lKwota.setBounds(100, 400, 150, 40);
		lKwota.setFont(font2);
		midPanel.add(lKwota);
		
		tfKwota = new JTextField("");
		tfKwota.setBounds(300, 400, 150, 40);
		midPanel.add(tfKwota);

		bSave = new JButton("Zapisz");
		bSave.setBounds(225, 450, 150, 50);
		midPanel.add(bSave);

		bClose = new JButton("Zamknij");
		bClose.setBounds(500, 550, 100, 50);
		midPanel.add(bClose);
		
		bReturn = new JButton("Powrót");
		bReturn.setBounds(0, 550, 100, 50);
		midPanel.add(bReturn);

		bSave.addActionListener(this);
		bClose.addActionListener(this);
		bReturn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bSave) {
			String imie = tfImie.getText();
			String nazwisko = tfNazwisko.getText();
			String bank = tfBank.getText();
			String nrKarty = tfNrKarty.getText();
			String pin = tfPin.getText();
			String tele = tfTele.getText();
			String pom = tfKwota.getText();
			float kwota = 0;
			if ((imie.length() > 1) && (nazwisko.length() > 1) && (bank.length() > 1)
					&& (nrKarty.length() > 1) && (pin.length() == 4) && (tele.length() > 7)) {
				try {
					kwota = Float.parseFloat(pom);
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					df.format(kwota);
					Klient klient = new Klient(imie, nazwisko, bank, nrKarty, pin, tele, kwota);
					klient.addCus();
					JOptionPane.showMessageDialog(null, "Zapisano", "Dodawanie klienta", JOptionPane.INFORMATION_MESSAGE);
					klient.readCus();
				} catch (IOException exception) {
					exception.printStackTrace();
				} catch (ClassNotFoundException exception) {
					JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Dodawanie klienta",
							JOptionPane.INFORMATION_MESSAGE);
					exception.printStackTrace();
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Dodawanie klienta",
							JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Nieprawidłowa kwota");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Dodawanie klienta", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (source == bReturn) {
			dispose();
			GuiServMenu service = new GuiServMenu();
			service.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			service.setVisible(true);
		} else if (source == bClose) {
			dispose();
		}
	}
}