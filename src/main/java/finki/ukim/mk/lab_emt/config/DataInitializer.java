package finki.ukim.mk.lab_emt.config;

import finki.ukim.mk.lab_emt.model.*;
import finki.ukim.mk.lab_emt.model.enums.Category;
import finki.ukim.mk.lab_emt.model.enums.Role;
import finki.ukim.mk.lab_emt.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final ReservationRepository reservationRepository;
    private final SmestuvanjeRepository smestuvanjeRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, ReservationRepository reservationRepository, SmestuvanjeRepository smestuvanjeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.reservationRepository = reservationRepository;
        this.smestuvanjeRepository = smestuvanjeRepository;

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void initialize() {
        Country country1=countryRepository.save(new Country("MK", "EU"));
        Country country2=countryRepository.save(new Country("UK", "EU"));
        Country country3=countryRepository.save(new Country("US", "NA"));

        Host host1=hostRepository.save(new Host("lj", "jo",country1));
        Host host2=hostRepository.save(new Host("ac", "ji",country2));
        Host host3=hostRepository.save(new Host("na", "dm",country3));

        Smestuvanje smestuvanje1=smestuvanjeRepository.save(new Smestuvanje("grant", Category.HOTEL,host1,100));
        Smestuvanje smestuvanje2=smestuvanjeRepository.save(new Smestuvanje("victo", Category.APARTMENT,host2,10));
        Smestuvanje smestuvanje3=smestuvanjeRepository.save(new Smestuvanje("baraka", Category.ROOM,host3,2));

//        reservationRepository.save(new Reservation(smestuvanje1,4, LocalDate.now(),LocalDate.now(),"ljupce"));
//        reservationRepository.save(new Reservation(smestuvanje2,2, LocalDate.now(),LocalDate.now(),"risto"));
//        reservationRepository.save(new Reservation(smestuvanje3,1, LocalDate.now(),LocalDate.now(),"blazo"));

        userRepository.save(new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                "admin",
                Role.ROLE_Host
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "ljupce",
                "221277",
                Role.ROLE_USER
        ));
    }
//    @PostConstruct
//    public void init() {
//
//        userRepository.save(new User(
//                "admin",
//                passwordEncoder.encode("admin"),
//                "admin",
//                "admin",
//                Role.ROLE_Host
//        ));
//
//        userRepository.save(new User(
//                "user",
//                passwordEncoder.encode("user"),
//                "ljupce",
//                "221277",
//                Role.ROLE_USER
//        ));
//    }
}

