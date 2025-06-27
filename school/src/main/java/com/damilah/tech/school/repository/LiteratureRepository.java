package com.damilah.tech.school.repository;

import com.damilah.tech.school.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature,Long> {
}
