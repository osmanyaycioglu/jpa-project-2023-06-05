package com.training.jpa;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class CustomerDetails {
    private Integer height;
    private Integer weight;
    private LocalDate birthday;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
