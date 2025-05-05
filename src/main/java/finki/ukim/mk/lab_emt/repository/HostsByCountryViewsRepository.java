package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.views.HostsByCountryViews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HostsByCountryViewsRepository extends JpaRepository<HostsByCountryViews, Long> {
    public List<HostsByCountryViews> findAll();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.by_country",nativeQuery = true)
    public void refreshMaterializedView();
}
