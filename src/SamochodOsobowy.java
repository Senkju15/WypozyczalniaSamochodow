public class SamochodOsobowy extends Pojazd {
    private int liczbaDrzwi;

    public SamochodOsobowy(String marka, String model, int rokProdukcji, double stawkaZaDobe, int liczbaDrzwi) {
        super(marka, model, rokProdukcji, stawkaZaDobe);
        this.liczbaDrzwi = liczbaDrzwi;
    }

    @Override
    public double obliczKosztWynajmu(int liczbaDni) {
        return liczbaDni * stawkaZaDobe;
    }
}
