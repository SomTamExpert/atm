package ch.swiss.nex.km.springbootvuecrudapp.repository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Karte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KarteRepository extends JpaRepository<Karte,Long> {
}
