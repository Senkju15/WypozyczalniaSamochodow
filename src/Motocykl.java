public class Motocykl extends Pojazd {
    private String typNapedu;

    public Motocykl(String marka, String model, int rokProdukcji, double stawkaZaDobe, String typNapedu) {
        super(marka, model, rokProdukcji, stawkaZaDobe);
        this.typNapedu = typNapedu;
    }

    @Override
    public double obliczKosztWynajmu(int liczbaDni) {
        return liczbaDni * stawkaZaDobe;
    }

    @Override
    public boolean weryfikujUprawnieniaKierowcy(Klient klient) {
        return true;
    }
}
