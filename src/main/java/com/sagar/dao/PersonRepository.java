package com.sagar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagar.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
