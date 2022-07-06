package ch.bbw.km.repository;

import ch.bbw.km.model.Karte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KarteRepository extends JpaRepository<Karte,Long> {
    // get card by bard nummer
    Karte findKarteByNummer(int nummer);
}
