package unv.nordic.service;

import org.springframework.stereotype.Service;
import unv.nordic.entity.User;
import unv.nordic.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
