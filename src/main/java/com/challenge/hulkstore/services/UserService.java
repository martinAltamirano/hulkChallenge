package com.challenge.hulkstore.services;

import com.challenge.hulkstore.errors.UserNotFoundException;
import com.challenge.hulkstore.models.User;
import com.challenge.hulkstore.models.UserRole;
import com.challenge.hulkstore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository repository;

    private final PasswordEncoder encoder;

    public User newUser(User user) {
        user.setUsername(encoder.encode(user.getUsername()));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));

        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    public User editUser(User user, Long id) {
        return getUserById(id).map(p -> {
                    p.setFirstName(user.getFirstName());
                    return repository.save(p);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(user);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
