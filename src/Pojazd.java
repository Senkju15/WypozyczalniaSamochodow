public abstract class Pojazd implements Ubezpieczalny, WymagaPrawaJazdyKatB {
    protected String marka;
    protected String model;
    protected int rokProdukcji;
    protected double stawkaZaDobe;
    protected boolean czyDostepny;
    protected boolean statusUbezpieczenia;

    public Pojazd(String marka, String model, int rokProdukcji, double stawkaZaDobe) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.stawkaZaDobe = stawkaZaDobe;
        this.czyDostepny = true; // domyślnie dostępny
        this.statusUbezpieczenia = false;
    }

    public abstract double obliczKosztWynajmu(int liczbaDni);

    public void aktywujPoliseOchronna() {
        this.statusUbezpieczenia = true;
        System.out.println("Polisa ubezpieczeniowa dla " + marka + " " + model + " została aktywowana.");
    }

    public boolean weryfikujUprawnieniaKierowcy(Klient klient) {
        return klient.posiadaPrawoJazdyKatB;
    }

    public boolean isCzyDostepny() { return czyDostepny; }
    public void setCzyDostepny(boolean czyDostepny) { this.czyDostepny = czyDostepny; }

    public String toString() {
        return marka + " " + model + " (" + rokProdukcji + ")";
    }
}