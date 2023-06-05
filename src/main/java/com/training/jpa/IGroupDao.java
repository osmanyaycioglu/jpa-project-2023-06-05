package com.training.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupDao extends JpaRepository<Group,String> {
}
