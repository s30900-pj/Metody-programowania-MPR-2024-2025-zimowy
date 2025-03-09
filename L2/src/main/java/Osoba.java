public class Osoba {
    String imie;
    String nazwisko;
    String numerTelefonu;
    Pizza zamowionaPizza;

    public Osoba(String imie, String nazwisko, String numerTelefonu, Pizza zamowionaPizza) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.zamowionaPizza = zamowionaPizza;
    }

    public void wyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Numer telefonu: " + numerTelefonu);
    }
    public void wyswietlParagon() {
        System.out.println("\n--- Paragon ---");
        wyswietlInformacje();
        System.out.println("Zamówiona pizza: " + zamowionaPizza);
        System.out.println("Do zapłaty: " + zamowionaPizza.cena + " zł");
        System.out.println("Opłata przeszła: " + (zamowionaPizza.oplataPrzeszla ? "Tak" : "Nie"));
        System.out.println("-----------------");
    }
}
