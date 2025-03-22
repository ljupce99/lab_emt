package finki.ukim.mk.lab_emt.model.dto;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.enums.Category;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class SmestuvanjeDto {
    String name;
    Category category;
    Long host;
    Integer numRooms;

    public SmestuvanjeDto(String name, Category category, Long host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Long getHost() {
        return host;
    }

    public void setHost(Long host) {
        this.host = host;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
