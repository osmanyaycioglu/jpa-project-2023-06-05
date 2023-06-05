package com.training.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Component
public class AppRunMe implements ApplicationRunner {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IGroupDao groupDao;

//    @PersistenceContext
//    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Random random = new SecureRandom();
        Customer customer = new Customer();
        customer.setName("osman" + random.nextInt());
        customer.setSurname("yaycıoğlu");
        customer.setMiddleName("tulgar");
        customer.setXyz("asd");
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setBirthday(LocalDate.of(1970,
                                                 9,
                                                 11));
        customerDetails.setHeight(200);
        customerDetails.setWeight(90);
        customer.setCustomerDetails(customerDetails);
        CustomerDates customerDates = new CustomerDates();
        customerDates.setCreateDate(LocalDateTime.now());
        customerDates.setUpdateDate(LocalDateTime.now());
        customer.setCustomerDates(customerDates);
        customerDates.setCustomer(customer);
        Set<Phone> phones = new HashSet<>();
        Phone phone1 = new Phone();
        phone1.setPhoneName("ev");
        phone1.setPhoneNumber("4938394");
        phone1.setCustomer(customer);
        phones.add(phone1);
        Phone phone2 = new Phone();
        phone2.setPhoneName("ofis");
        phone2.setPhoneNumber("4387534785");
        phone2.setCustomer(customer);
        phones.add(phone2);
        customer.setPhones(phones);

        Set<Group> groups = new HashSet<>();
        Group group1 = new Group();
        group1.setGroupName("IT");
        group1.setGroupDesc("Teknoloji");
        groups.add(group1);

        Group byId = groupDao.findById(group1.getGroupName())
                             .orElse(null);

        if (!groupDao.existsById(group1.getGroupName())) {
            groupDao.save(group1);
        }

        Group group2 = new Group();
        group2.setGroupName("HALAY");
        group2.setGroupDesc("Halay çekenler");
        groups.add(group2);

        if (!groupDao.existsById(group2.getGroupName())) {
            groupDao.save(group2);
        }

        customer.setGroups(groups);

        customerDao.save(customer);
    }
}
