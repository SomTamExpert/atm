package ch.bbw.km.repository;

import ch.bbw.km.model.Karte;
import ch.bbw.km.model.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepository extends JpaRepository<Konto,Long> {

    Konto findKontoByKarte(Karte karte);

}
