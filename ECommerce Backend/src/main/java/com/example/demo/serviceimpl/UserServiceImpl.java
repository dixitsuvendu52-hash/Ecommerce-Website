package com.example.demo.serviceimpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // ✅ Constructor injection
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
                     
    @Override
    public User register(User user) {
        if (user.getRole() == null) user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public User login(String email,String password) {
    	return userRepository.findByEmailAndPassword(email,password);
    /*    User u = userRepository.findByUsername(username);
        if (u == null) return null;
        if (!u.getPassword().equals(password)) return null;
        return u;*/
    }

    @Override
    public User findById(Long id) {
        Optional<User> o = userRepository.findById(id);
        return o.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setPhone(user.getPhone());
            existing.setAddress(user.getAddress());
            existing.setRole(user.getRole());
            existing.setPassword(user.getPassword());
            return userRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
