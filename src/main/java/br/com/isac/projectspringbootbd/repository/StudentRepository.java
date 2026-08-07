package br.com.isac.projectspringbootbd.repository;

import br.com.isac.projectspringbootbd.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
