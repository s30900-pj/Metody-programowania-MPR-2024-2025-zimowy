public class Main {
    public static void main(String[] args) {

        Restauracja restauracja = new Restauracja();
        restauracja.wyswietlMenu();

        Pizza pizzaHawajska = restauracja.znajdzPizze("Hawajska");

        if (pizzaHawajska != null) {
            Osoba osoba = new Osoba("Jan", "Kowalski", "123-456-789", pizzaHawajska);

            System.out.println("\nDane osoby:");
            osoba.wyswietlInformacje();

            osoba.wyswietlParagon();
        } else {
            System.out.println("Nie znaleziono wybranej pizzy.");
        }
    }
}
