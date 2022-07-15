package ru.ageevvo.crud_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ageevvo.crud_spring_boot.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
