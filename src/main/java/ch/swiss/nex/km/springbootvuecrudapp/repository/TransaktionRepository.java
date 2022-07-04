package ch.swiss.nex.km.springbootvuecrudapp.repository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Transaktion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaktionRepository extends JpaRepository<Transaktion,Long> {
}
