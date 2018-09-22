package com.example.student.repository;

import com.example.student.dao.entity.FromJsonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FromJsonRepository extends JpaRepository<FromJsonEntity,Integer> {
}
