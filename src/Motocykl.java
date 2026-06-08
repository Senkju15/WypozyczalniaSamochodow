public class Motocykl extends Pojazd {
    private String typNapedu; // np. łańcuch, wał

    public Motocykl(String marka, String model, int rokProdukcji, double stawkaZaDobe, String typNapedu) {
        super(marka, model, rokProdukcji, stawkaZaDobe);
        this.typNapedu = typNapedu;
    }

    @Override
    public double obliczKosztWynajmu(int liczbaDni) {
        return liczbaDni * stawkaZaDobe; // Motocykle mogą mieć stałą stawkę
    }

    @Override
    public boolean weryfikujUprawnieniaKierowcy(Klient klient) {
        // Dla motocykla potrzebna kategoria A, więc domyślne sprawdzanie Kat B może nie wystarczyć,
        // ale w ramach projektu załóżmy, że klient potrzebuje specyficznych uprawnień,
        // tutaj dla uproszczenia zwrócimy true (albo zmodyfikujcie pod siebie).
        return true;
    }
}
