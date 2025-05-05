package finki.ukim.mk.lab_emt.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.by_country")
@Immutable
public class HostsByCountryViews {
    @Id @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "continent")
    String continent;
    @Column(name = "domakini")
    int domakini;
}
