import java.util.ArrayList;
import java.util.List;

public class Restauracja {
    List<Pizza> listaPizz;

    public Restauracja() {
        listaPizz = new ArrayList<>();
        dodajPizze();
    }

    private void dodajPizze() {
        listaPizz.add(new Pizza("Margarita", 20.0, true));
        listaPizz.add(new Pizza("Diavola", 25.0, false));
        listaPizz.add(new Pizza("Hawajska", 23.0, true));
        listaPizz.add(new Pizza("Peperoni", 27.0, false));
    }

    public void wyswietlMenu() {
        System.out.println("\n Menu restauracji:");
        for (Pizza pizza : listaPizz) {
            System.out.println(pizza);
        }
    }
    public Pizza znajdzPizze(String nazwa) {
        for (Pizza pizza : listaPizz) {
            if (pizza.nazwa.equalsIgnoreCase(nazwa)) {
                return pizza;
            }
        }
        return null;
    }
}
