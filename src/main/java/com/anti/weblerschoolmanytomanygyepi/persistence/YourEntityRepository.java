package com.anti.weblerschoolmanytomanygyepi.persistence;


import com.anti.weblerschoolmanytomanygyepi.entity.base.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YourEntityRepository extends JpaRepository<YourEntity, Long> {
}
