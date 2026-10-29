package com.java.bolo_tematico.service;

import com.java.bolo_tematico.model.Role;
import com.java.bolo_tematico.model.User;
import com.java.bolo_tematico.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;

    public User login(String username, String password) {
        System.out.println(username);
        System.out.println(password);

        return userRepo.findByUsername(username)
                .filter(user -> BCrypt.checkpw(password, user.getPassword()))
                .orElse(null);
    }

    public void register(String username, String password, Role role) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        User user = new User();
        user.setUsername(username);
        user.setPassword(hash);
        user.setRole(role);
        userRepo.save(user);
    }

}
