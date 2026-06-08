public class Main {
    public static void main(String[] args) {
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        Pojazd auto = new SamochodOsobowy("Toyota", "Corolla", 2022, 150.0, 5);
        Pojazd van = new Dostawczy("Ford", "Transit", 2020, 250.0, 3500.0);
        Pojazd moto = new Motocykl("Yamaha", "MT-07", 2023, 100.0, "Łańcuch");

        wypozyczalnia.dodajPojazd(auto);
        wypozyczalnia.dodajPojazd(van);
        wypozyczalnia.dodajPojazd(moto);

        Klient klientZUprawnieniami = new Klient("Jan Kowalski", true);
        Klient klientBezUprawnien = new Klient("Anna Nowak", false);

        System.out.println("--- PRÓBA 1: Pomyślne wypożyczenie auta ---");
        wypozyczalnia.wypozyczPojazd(auto, klientZUprawnieniami, 3);

        System.out.println("\n--- PRÓBA 2: Wypożyczenie już zajętego auta ---");
        wypozyczalnia.wypozyczPojazd(auto, klientZUprawnieniami, 2);

        System.out.println("\n--- PRÓBA 3: Brak uprawnień ---");
        wypozyczalnia.wypozyczPojazd(van, klientBezUprawnien, 5);

        System.out.println("\n--- DOSTĘPNA FLOTA ---");
        for(Pojazd p : wypozyczalnia.pobierzDostepnePojazdy()) {
            System.out.println("- " + p.toString());
        }
    }
}