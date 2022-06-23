package atm_final2;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
/**
 * @author Jan Niedziolka
 *
 */
public class Bankomat extends JFrame implements Serializable, IBankomat {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7944933045756819876L;
	private HashMap<String, Integer> banknoty = new HashMap<String, Integer>();
	
	public void set10(int dziesiec) {
		this.banknoty.put("10pln", dziesiec);
	}
	public void set20(int dwadziescia) {
		this.banknoty.put("20pln", dwadziescia);
	}
	public void set50(int piecdziesiat) {
		this.banknoty.put("50pln", piecdziesiat);
	}
	public void set100(int sto) {
		this.banknoty.put("100pln", sto);
	}
	public void set200(int dwiescie) {
		this.banknoty.put("200pln", dwiescie);
	}
	public void set500(int piecset) {
		this.banknoty.put("500pln", piecset);
	}
	
	public int get10() {
		if(banknoty.get("10pln") == null) {
			set10(0);
			return 0;
		}
		else 
			return banknoty.get("10pln");
	}
	public int get20() {
		if(banknoty.get("20pln") == null) {
			set20(0);
			return 0;
		}
		else 
			return banknoty.get("20pln");
	}
	public int get50() {
		if(banknoty.get("50pln") == null) {
			set50(0);
			return 0;
		}
		else 
			return banknoty.get("50pln");
	}
	public int get100() {
		if(banknoty.get("100pln") == null) {
			set100(0);
			return 0;
		}
		else 
			return banknoty.get("100pln");
	}
	public int get200() {
		if(banknoty.get("200pln") == null) {
			set200(0);
			return 0;
		}
		else
			return banknoty.get("200pln");
	}
	public int get500() {
		if(banknoty.get("500pln") == null) {
			set500(0);
			return 0;
		}
		else
			return banknoty.get("500pln");
	}
	
	public void setSuma() {
		int suma = ((10*banknoty.get("10pln")) + (20*banknoty.get("20pln")) + (50*banknoty.get("50pln"))
				+ (100*banknoty.get("100pln")) + (200*banknoty.get("200pln")) + (500*banknoty.get("500pln")));
		this.banknoty.put("suma", suma);
	}
	public int getSuma() {
		if(banknoty.get("suma") == null)
			return 0;
		else 
			return banknoty.get("suma");
	}
	
	
	public Bankomat() {
	}
	public Bankomat(int dziesiec, int dwadziescia, int piecdziesiat, int sto, int dwiescie, int piecset) {
		this.banknoty.put("10pln", dziesiec);
		this.banknoty.put("20pln", dwadziescia);
		this.banknoty.put("50pln", piecdziesiat);
		this.banknoty.put("100pln", sto);
		this.banknoty.put("200pln", dwiescie);
		this.banknoty.put("500pln", piecset);
		int suma = ((10*banknoty.get("10pln")) + (20*banknoty.get("20pln")) + (50*banknoty.get("50pln"))
				+ (100*banknoty.get("100pln")) + (200*banknoty.get("200pln")) + (500*banknoty.get("500pln")));
		this.banknoty.put("suma", suma);
	}

	public void toFile() throws IOException, ClassNotFoundException {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("bankomat.txt"));
			outputStream.writeObject(this);
			outputStream.flush();
		} finally {
			if(outputStream != null)
				outputStream.close();
		}
	}

	public void fromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = null;
		Bankomat atm = null;
		try{
			inputStream = new ObjectInputStream(new FileInputStream("bankomat.txt"));
			while(true) {
				atm = (Bankomat) inputStream.readObject();
				this.set500(atm.get500());
				this.set200(atm.get200());
				this.set100(atm.get100());
				this.set50(atm.get50());
				this.set20(atm.get20());
				this.set10(atm.get10());
				this.setSuma();
			}
		} catch (EOFException ex) {
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	@Override
	public void IWplata(Klient cus, int kwota, int i500, int i200, int i100, int i50, int i20, int i10){
		int confirm = kwota;
		try {
			this.set500(get500() + i500);
			this.set200(get200() + i200);
			this.set100(get100() + i100);
			this.set50(get50() + i50);
			this.set20(get20() + i20);
			this.set10(get10() + i10);
			this.setSuma();
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
		}
		IPotwierdzenie(confirm, "wpłata środków", cus.getSrodki());
	}
	
	@Override
	public void IWyplata(Klient cus, int k){
		int i500 = 0, i200 = 0, i100 = 0, i50 = 0, i20 = 0, i10 = 0;
		float saldo = cus.getSrodki();
		int confirm = k;
		if(k >= 500) {
			i500 = (int)k/500;
			if(banknoty.get("500pln") >= i500)
				k = (k - (i500 * 500));
			else {
				i500 = banknoty.get("500pln");
				k = (k - (i500 * 500));
			}
		}
		if(k >= 200) {
			i200 = (int)k/200 ;
			if(banknoty.get("200pln") >= i200)
				k = (k - (i200 * 200));
			else {
				i200 = banknoty.get("pln200");
				k = (k - (i200 * 200));
			}
		}
		if(k >= 100) {
			i100 = (int)k/100 ;
			if(banknoty.get("100pln") >= i100)
				k = (k - (i100 * 100));
			else {
				i100 = banknoty.get("100pln");
				k = (k - (i100 * 100));
			}
		}
		if(k >= 50) {
			i50 = (int)k/50 ;
			if(banknoty.get("50pln") >= i50)
				k = (k - (i50 * 50));
			else {
				i50 = banknoty.get("50pln");
				k = (k - (i50 * 50));
			}
		}
		if(k >= 20) {
			i20 = (int)k/20 ;
			if(banknoty.get("20pln") >= i20)
				k = (k - (i20 * 20));
			else {
				i20 = banknoty.get("20pln");
				k = (k - (i20 * 20));
			}
		}
		if(k >= 10) {
			i10 = (int)k/10 ;
			if(banknoty.get("10pln") >= i10)
				k = (k - (i10 * 10));
			else {
				i10 = banknoty.get("10pln");
				k = (k - (i10 * 10));
			}
		}
		
		if (k == 0) {
			try {
				this.set500(get500() - i500);
				this.set200(get200() - i200);
				this.set100(get100() - i100);
				this.set50(get50() - i50);
				this.set20(get20() - i20);
				this.set10(get10() - i10);
				this.setSuma();
				this.toFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Błąd", JOptionPane.INFORMATION_MESSAGE);
				exception.printStackTrace();
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "Wynik", JOptionPane.INFORMATION_MESSAGE);
			}
			
			IPotwierdzenie(confirm, "wypłata środków", saldo);
		} else {
			JOptionPane.showMessageDialog(null, "Brak srodkow w bankomacie", "Wynik", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public void IPotwierdzenie(int k, String rodzajOperacji, float saldo) {
		//data operacji
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd', 'HH:mm:ss"); 
		String date = sdf.format(new Date());
		//rodzaj operacji
		//kwota operacji
		//saldo po operacji
		String inf = "Data wykonania operacji: "+date +
				"\nRodzaj wykonanej operacji: "+rodzajOperacji + 
				"\nKwota operacji: " + k + " PLN" +
				"\nSaldo po operacji: " + saldo;
		JOptionPane.showMessageDialog(null, inf, "Potwierdzenie: ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void IWydruk(Klient cus) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd', 'HH:mm:ss");   
		String date = sdf.format(new Date());
		String wydruk = ("Stan konta w " + date + ": " + cus.getSrodki());
		JOptionPane.showMessageDialog(null, wydruk, "Drukowanie stanu konta: ", JOptionPane.INFORMATION_MESSAGE);
	}	
}
