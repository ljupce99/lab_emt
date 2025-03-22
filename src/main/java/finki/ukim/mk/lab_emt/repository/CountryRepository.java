package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}



