package atm_final2;

import java.io.IOException;
import javax.security.auth.login.AccountException;

public interface IBankomat{

	void IWyplata(Klient cus, int k) throws AccountException;

	void IWydruk(Klient cus);

	void IWplata(Klient cus, int kwota, int i500, int i200, int i100, int i50, int i20, int i10) throws CalcException;

	void IPotwierdzenie(int k, String rodzajOperacji, float before);

}