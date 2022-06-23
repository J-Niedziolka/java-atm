package atm_final2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Klient extends Osoba{
	private String nrKarty, pin, tele;
	private float srodki;

	public Klient(String i, String n, String b, String nrKarty, String pin, String tele, float srodki) {
		super(i, n, b);
		this.nrKarty = nrKarty;
		this.pin = pin;
		this.tele = tele;
		this.srodki = srodki;
	}
	
	public void setNrKarty(String nK) {
		this.nrKarty = nK;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public void setTele(String tel) {
		this.tele = tel;
	}
	public void setSrodki(float srodki) {
		this.srodki = srodki;
	}
	
	public String getNrKarty() {
		return nrKarty;
	}
	public String getPin() {
		return pin;
	}
	public String getTele() {
		return tele;
	}
	public float getSrodki() {
		return srodki;
	}

	public void addCus() throws IOException, ClassNotFoundException{
		Klient[] arr = new Klient[50];
		ObjectInputStream update = null;
		int count = 0;
		
		try {
			update = new ObjectInputStream(new FileInputStream("klient.txt"));
			while(true) {
				arr[count] = (Klient)update.readObject();
				count++;
			}
		} catch(EOFException e) {
			if(update != null)
				update.close();
			
			ObjectOutputStream write = null;
			try {
				write = new ObjectOutputStream(new FileOutputStream("klient.txt"));
				for(int i = 0; arr[i] != null; i++)
					write.writeObject(arr[i]);
			
				write.writeObject(this);
				count++;
				write.flush();
			} finally {
				if(write != null)
					write.close();
			}
		} catch(IOException e) {
			System.out.println("Klient//addCus//IOExeption");
		}
	}

	public void readCus() throws IOException, ClassNotFoundException{
		Object[][] arr = new Object[50][7];
		ObjectInputStream read = null;
		Klient cus = null;
		int count = 0;
		
		try {
			read = new ObjectInputStream(new FileInputStream("klient.txt"));
			while(true) {
				cus = (Klient)read.readObject();
				arr[count][0] = cus.getImie();
				arr[count][1] = cus.getNazwisko();
				arr[count][2] = cus.getBank();
				arr[count][3] = cus.getNrKarty();
				arr[count][4] = cus.getPin();
				arr[count][5] = cus.getTele();
				arr[count][6] = cus.getSrodki();
				count++;
			}
		} catch(EOFException e) {
		} finally {
			if(read != null)
				read.close();
			/*for(int i = 0; i < count; i++) {
				for(int j = 0; j < 7; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}*/
		}
	}
}
