package ch.swiss.nex.km.springbootvuecrudapp.repository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Erlaubnis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErlaubnisRepository extends JpaRepository<Erlaubnis,Long> {
}
