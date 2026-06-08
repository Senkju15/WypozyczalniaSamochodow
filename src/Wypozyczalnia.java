import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wypozyczalnia {
    private ArrayList<Pojazd> flota;

    public Wypozyczalnia() {
        this.flota = new ArrayList<>();
    }

    public void dodajPojazd(Pojazd p) {
        flota.add(p);
    }

    public List<Pojazd> pobierzDostepnePojazdy() {
        return flota.stream()
                .filter(Pojazd::isCzyDostepny)
                .collect(Collectors.toList());
    }

    public void wypozyczPojazd(Pojazd pojazd, Klient klient, int liczbaDni) {
        try {
            if (!pojazd.isCzyDostepny()) {
                throw new PojazdNiedostepnyException("Pojazd " + pojazd.toString() + " jest niedostępny lub wycofany z ruchu.");
            }

            if (!pojazd.weryfikujUprawnieniaKierowcy(klient)) {
                throw new BrakUprawnienException("Klient " + klient.imie + " nie ma wymaganych uprawnień do wypożyczenia " + pojazd.toString() + ".");
            }

            pojazd.setCzyDostepny(false);
            pojazd.aktywujPoliseOchronna();
            double koszt = pojazd.obliczKosztWynajmu(liczbaDni);

            System.out.println("SUKCES: " + klient.imie + " wypożyczył " + pojazd.toString() + " na " + liczbaDni + " dni. Koszt: " + koszt + " PLN.");

        } catch (PojazdNiedostepnyException | BrakUprawnienException e) {
            System.out.println("BŁĄD WYPOŻYCZENIA: " + e.getMessage());
        }
    }
}