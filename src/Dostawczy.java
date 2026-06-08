public class Dostawczy extends Pojazd {
    private double maksymalnaLadownosc;

    public Dostawczy(String marka, String model, int rokProdukcji, double stawkaZaDobe, double maksymalnaLadownosc) {
        super(marka, model, rokProdukcji, stawkaZaDobe);
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }

    public double obliczKosztWynajmu(int liczbaDni) {
        double kosztBazowy = liczbaDni * stawkaZaDobe;
        double oplataWagowa = Math.ceil(maksymalnaLadownosc / 1000.0) * 50.0 * liczbaDni;
        return kosztBazowy + oplataWagowa;
    }
}
