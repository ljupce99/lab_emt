package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.views.AccommodationsByHostViews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccommodationsByHostViewsRepository extends JpaRepository<AccommodationsByHostViews, Long> {
    public List<AccommodationsByHostViews> findAll();
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.by_host",nativeQuery = true)
    public void refreshMaterializedView();
}
