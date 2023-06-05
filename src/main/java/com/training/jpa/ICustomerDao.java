package com.training.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

    List<Customer> findBySurname(String surname);

    List<Customer> findByNameAndSurname(String name,
                                        String surname);

    List<Customer> findBySurnameIn(List<String> surname);

    List<Customer> findByNameAndSurnameOrderByName(String name,
                                                   String surname);

    @Query("select c from Customer c where c.surname=?1")
    List<Customer> searchSurname(String surname);

    @Query(value = "select * from z_customer c where c.surname=?1", nativeQuery = true)
    List<Customer> searchNativeSurname(String surname);

    @Query("select c from Customer c where c.name=?1 and c.surname=?2")
    List<Customer> searchNameAndSurname(String name,
                                        String surname);

    @Query("select c from Customer c where c.name=:name and c.surname=:sur")
    List<Customer> searchNameAndSurname2(@Param("name") String name,
                                         @Param("sur") String surname);

    @Query("select c.name,c.surname from Customer c where c.name=:name and c.surname=:sur")
    List<Object[]> searchObject(@Param("name") String name,
                                @Param("sur") String surname);

}
