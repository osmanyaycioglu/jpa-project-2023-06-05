package com.training.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerDates {
    @Id
    @GeneratedValue
    private Long cdId;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
