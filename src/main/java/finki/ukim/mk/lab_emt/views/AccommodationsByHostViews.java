package finki.ukim.mk.lab_emt.views;

import finki.ukim.mk.lab_emt.model.Country;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM by_host")
@Immutable
public class AccommodationsByHostViews {
    @Id @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "country_id")
    Long countryid;
    @Column(name = "smestuvanja")
    int smestuvanja;
}


//
//

//public class ProductsPerCategoryView {
//
//    @Id
//    @Column(name = "category_id")
//    private Long categoryId;
//
//    @Column(name = "num_products")
//    private Integer numProducts;
//}
