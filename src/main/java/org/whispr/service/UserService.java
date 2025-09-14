package org.whispr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whispr.dto.response.UserResponse;
import org.whispr.entity.User;
import org.whispr.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToUser)
                .collect(Collectors.toList());
    }

    public Optional<UserResponse> getUserById(String id) {
        return userRepository.findById(id).map(this::convertToUser);
    }

    public Optional<UserResponse> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::convertToUser);
    }

    public Optional<UserResponse> getUserByUsername(String username) {
        return userRepository.findByUsername(username).map(this::convertToUser);
    }

    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void updateUserStatus(String username, boolean isOnline) {
        userRepository.findByUsername(username).ifPresent(user -> {
            user.setStatus(isOnline ? "ONLINE" : "OFFLINE");
            userRepository.save(user);
        });
    }

    public User registerUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setName(signupRequest.getName());
        return userRepository.save(user);
    }

    private UserResponse convertToUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setName(user.getName());
        response.setBio(user.getBio());
        response.setProfilePicture(user.getProfilePicture());
        response.setEmail(user.getEmail());
        response.setOnline("ONLINE".equalsIgnoreCase(user.getStatus()));
        response.setRole(user.getRole());
        response.setLastSeen(user.getLastSeen());
        response.setChatRooms(user.getChatRooms());
        response.setBlockedUsers(user.getBlockedUsers());
        response.setFriendsList(user.getFriendsList());
        response.setGroupsJoined(user.getGroupsJoined());

        return response;
    }
}
