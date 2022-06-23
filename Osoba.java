package atm_final2;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
	private String imie, nazwisko, bank;

	public Osoba(String i, String n, String b) {
		this.imie = i;
		this.nazwisko = n;
		this.bank = b;
	}

	public String getImie() {
		return imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public String getBank() {
		return bank;
	}
	
	public void setImie(String i) {
		this.imie = i;
	}
	public void setNazwisko(String n) {
		this.nazwisko = n;
	}
	public void setBank(String b) {
		this.bank = b;
	}
}
