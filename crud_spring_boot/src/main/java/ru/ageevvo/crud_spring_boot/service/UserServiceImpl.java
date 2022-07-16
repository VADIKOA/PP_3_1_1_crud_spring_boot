package ru.ageevvo.crud_spring_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ageevvo.crud_spring_boot.models.User;
import ru.ageevvo.crud_spring_boot.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
