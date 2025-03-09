public class Pizza {
    String nazwa;
    double cena;
    boolean oplataPrzeszla;

    public Pizza(String nazwa, double cena, boolean oplataPrzeszla) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.oplataPrzeszla = oplataPrzeszla;
    }
    @Override
    public String toString() {
        return "Pizza: " + nazwa + ", Cena: " + cena + " zł, Opłata przeszła: " + (oplataPrzeszla ? "Tak" : "Nie");
    }
}
