package ch.bbw.km.repository;

import ch.bbw.km.model.Transaktion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaktionRepository extends JpaRepository<Transaktion,Long> {
}
