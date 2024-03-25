package com.anti.weblerschoolmanytomanygyepi.persistence;

import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends   JpaRepository<School, Long> {
    School findSchoolByNameIgnoreCase(String name);
}
