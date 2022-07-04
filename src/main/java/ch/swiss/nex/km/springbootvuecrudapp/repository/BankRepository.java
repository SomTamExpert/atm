package ch.swiss.nex.km.springbootvuecrudapp.repository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
    @Override
    Bank getById(Long aLong);

    @Override
    <S extends Bank> S save(S entity);


}
