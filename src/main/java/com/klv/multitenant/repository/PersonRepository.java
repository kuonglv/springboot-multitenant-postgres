package com.klv.multitenant.repository;

import com.klv.multitenant.dto.PersonDto;
import com.klv.multitenant.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select new com.klv.multitenant.dto.PersonDto(p.id, p.name) from Person p")
    Page<PersonDto> people(Pageable pageable);

    @Query("select p from Person p where p.name = :name")
    Person findJpqlByName(String name);

    @Query(nativeQuery = true,
           value = "SELECT * FROM person WHERE name = :name")
    Person findSqlByName(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM person")
    int deleteAllRegardlessOfTenant();
}
