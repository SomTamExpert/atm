package ch.swiss.nex.km.springbootvuecrudapp.repository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde,Long> {
}
