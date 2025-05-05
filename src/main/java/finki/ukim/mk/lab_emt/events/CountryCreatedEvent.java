package finki.ukim.mk.lab_emt.events;

import finki.ukim.mk.lab_emt.model.Country;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
@Getter
public class CountryCreatedEvent extends ApplicationEvent {
    private LocalDateTime when;


    public CountryCreatedEvent(Country source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public CountryCreatedEvent(Country source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
