package br.com.isac.projectspringbootbd.repository;

import br.com.isac.projectspringbootbd.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
