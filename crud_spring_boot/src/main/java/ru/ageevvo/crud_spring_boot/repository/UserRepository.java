package ru.ageevvo.crud_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ageevvo.crud_spring_boot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
