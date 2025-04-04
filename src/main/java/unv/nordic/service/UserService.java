package unv.nordic.service;

import org.springframework.stereotype.Service;
import unv.nordic.entity.User;
import unv.nordic.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean userIsRegisterNumber(String phoneNumber) {
        return userRepository.existsUserByPhoneNumber(phoneNumber);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateLanguage(Long id, String language) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setLanguage(language);
        return userRepository.save(user);
    }
}
