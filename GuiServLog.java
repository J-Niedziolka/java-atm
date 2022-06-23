package atm_final2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiServLog extends Okno implements ActionListener {
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bEnter, bCancel, bClose, bReturn;
	private JTextField tfID;
	private JPasswordField pfPin;
	private JRadioButton r1, r2;
	private ButtonGroup group;
	private String identyfikator = "", pin = "";

	public GuiServLog() {
		setTitle("Serwis logowanie");

		JLabel lSesja = new JLabel("Sesja pracownicza");
		lSesja.setForeground(Color.red);
		lSesja.setBounds(0, 0, 300, 50);
		lSesja.setFont(font2);
		topPanel.add(lSesja);

		JLabel lIdentyfikator = new JLabel("Identyfikator: ");
		lIdentyfikator.setBounds(30, 100, 250, 40);
		lIdentyfikator.setFont(font2);
		midPanel.add(lIdentyfikator);

		tfID = new JTextField("");
		tfID.setBounds(250, 100, 100, 40);
		midPanel.add(tfID);

		JLabel lPin = new JLabel("Pin: ");
		lPin.setBounds(180, 200, 100, 40);
		lPin.setFont(font2);
		midPanel.add(lPin);

		pfPin = new JPasswordField("");
		pfPin.setBounds(250, 200, 100, 40);
		midPanel.add(pfPin);

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
		r1 = new JRadioButton("Nr Id");
		r2 = new JRadioButton("PIN");
		r1.setBounds(450, 350, 80, 20);
		r2.setBounds(450, 400, 80, 20);
		r1.setBackground(Color.GRAY);
		r2.setBackground(Color.GRAY);
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
				identyfikator = identyfikator + "1";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "1";
				pfPin.setText(pin);
			}
		} else if (source == b2) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "2";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "2";
				pfPin.setText(pin);
			}
		} else if (source == b3) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "3";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "3";
				pfPin.setText(pin);
			}
		} else if (source == b4) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "4";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "4";
				pfPin.setText(pin);
			}
		} else if (source == b5) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "5";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "5";
				pfPin.setText(pin);
			}
		} else if (source == b6) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "6";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "6";
				pfPin.setText(pin);
			}
		} else if (source == b7) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "7";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "7";
				pfPin.setText(pin);
			}
		} else if (source == b8) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "8";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "8";
				pfPin.setText(pin);
			}
		} else if (source == b9) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "9";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "9";
				pfPin.setText(pin);
			}
		} else if (source == b0) {
			if (r1.isSelected()) {
				identyfikator = identyfikator + "0";
				tfID.setText(identyfikator);
			} else if (r2.isSelected()) {
				pin = pin + "0";
				pfPin.setText(pin);
			}
		} else if (source == bCancel) {
			if (r1.isSelected()) {
				if (identyfikator.length() > 0) {
					String pom = "";
					for (int i = 0; i < identyfikator.length() - 1; i++) {
						pom = pom + identyfikator.charAt(i);
					}
					identyfikator = pom;
					tfID.setText(identyfikator);
				}
			} else if (r2.isSelected()) {
				if (pin.length() > 0) {
					String pom = "";
					for (int i = 0; i < pin.length() - 1; i++) {
						pom = pom + pin.charAt(i);
					}
					pin = pom;
					pfPin.setText(pin);
				}
			}
		} else if (source == bClose) {
			dispose();
		} else if(source == bReturn) {
			GuiEntry entry = new GuiEntry();
			entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			entry.setVisible(true);
		} else if (source == bEnter) {
			String identyfikator = tfID.getText();
			String pin = String.valueOf(pfPin.getPassword());
			if (identyfikator.equals("") && pin.equals("")) {
				dispose();
				GuiServMenu service = new GuiServMenu();
				service.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				service.setVisible(true);
			}
		}
	}
}
