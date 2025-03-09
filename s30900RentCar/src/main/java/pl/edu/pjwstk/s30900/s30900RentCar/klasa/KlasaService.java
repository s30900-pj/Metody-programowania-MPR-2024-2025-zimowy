package pl.edu.pjwstk.s30900.s30900RentCar.klasa;

import org.springframework.stereotype.Service;

@Service
public class KlasaService {
    private final KlasaRepository klasaRepository;

    public KlasaService(KlasaRepository klasaRepository) {
        this.klasaRepository = klasaRepository;
    }

    public Klasa findByID(int id) {
        Klasa selectedKlasa = null;
        for (Klasa klasa : klasaRepository.getAllKlasa()) {
            if (klasa.getId() == id) {
                selectedKlasa = klasa;
            }
        }
        if (selectedKlasa == null) {
            throw new RuntimeException("no such car was found");
        }
        return selectedKlasa;
    }
}
