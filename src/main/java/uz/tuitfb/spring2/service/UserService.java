package uz.tuitfb.spring2.service;

import org.springframework.stereotype.Service;
import uz.tuitfb.spring2.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
