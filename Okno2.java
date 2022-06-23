package atm_final2;

import javax.swing.JButton;
import javax.swing.JLabel;


public abstract class Okno2 extends Okno {
    protected JButton bReturn, bClose;
    
    public Okno2()
    {
    	JLabel label500 = new JLabel("500 PLN: " );
        label500.setBounds(120, 100, 250, 50);
        label500.setFont(font1);
        midPanel.add(label500);

        JLabel label200 = new JLabel("200 PLN: " );
        label200.setBounds(120, 150, 250, 50);
        label200.setFont(font1);
        midPanel.add(label200);

        JLabel label100 = new JLabel("100 PLN: " );
        label100.setBounds(120, 200, 250, 50);
        label100.setFont(font1);
        midPanel.add(label100);

        JLabel label50 = new JLabel("50 PLN: " );
        label50.setBounds(120, 250, 250, 50);
        label50.setFont(font1);
        midPanel.add(label50);

        JLabel label20 = new JLabel("20 PLN: " );
        label20.setBounds(120, 300, 250, 50);
        label20.setFont(font1);
        midPanel.add(label20);

        JLabel label10 = new JLabel("10 PLN: " );
        label10.setBounds(120, 350, 250, 50);
        label10.setFont(font1);
        midPanel.add(label10);

        JLabel labelSuma = new JLabel("Laczna kwota: " );
        labelSuma.setBounds(80, 450, 400, 50);
        labelSuma.setFont(font1);
        midPanel.add(labelSuma);

        bReturn = new JButton("Powrót");
        bReturn.setBounds(0, 550, 100, 50);
        midPanel.add(bReturn);
        
        bClose = new JButton("Zamknij");
        bClose.setBounds(500,550,100,50);
        midPanel.add(bClose);
    }
}
