package com.app.onebiteword.repository;

import com.app.onebiteword.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long> {
}
