package ch.bbw.km.repository;

import ch.bbw.km.model.Karte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface KarteRepository extends JpaRepository<Karte,Long> {

    Karte findKarteByNummer(String nummer);
}
