package atm_final2;

import javax.swing.*;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		GuiEntry entry = new GuiEntry();
		entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entry.setVisible(true);
	}
}
