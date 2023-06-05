package com.training.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "z_customer")
@SecondaryTable(name = "my_customer_second")
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;
    @Column(name = "first_name", length = 50, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 40, message = "name {min} ile {max} arasında olmalı")
    private String name;
    @Column(name = "last_name", length = 50, nullable = false)
    private String surname;

    @Column(table = "my_customer_second")
    private String middleName;

    @Transient
    private String xyz;

    @Embedded
    private CustomerDetails customerDetails;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private CustomerDates customerDates;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Phone> phones;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customers_group")
    private Set<Group> groups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

    public CustomerDates getCustomerDates() {
        return customerDates;
    }

    public void setCustomerDates(CustomerDates customerDates) {
        this.customerDates = customerDates;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
