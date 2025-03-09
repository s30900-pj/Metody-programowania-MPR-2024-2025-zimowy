package pl.edu.pjwstk.s30900.s30900RentCar.klasa;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlasaRepository {
    List<Klasa> klasaList;
    public KlasaRepository(List<Klasa> klasaList) {
        this.klasaList = klasaList;
        klasaList.add(new Klasa(1,"super",100d));
    }
    public List<Klasa> getAllKlasa() {
        return klasaList;
    }
}
