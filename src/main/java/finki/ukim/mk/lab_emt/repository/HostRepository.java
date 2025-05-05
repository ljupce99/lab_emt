package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.HostNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {

//    @Query("select h.name,h.surname from Host h ")
    public List<HostNameProjection> findAllBy();
}
