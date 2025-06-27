package com.damilah.tech.school.repository;

import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.enumerations.SubjectLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    List<Subject> findByNameContaining(String name);

}
