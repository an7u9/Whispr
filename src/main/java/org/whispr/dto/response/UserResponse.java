package org.whispr.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String name;
    private String bio;
    private String profilePicture;
    private boolean online; // true = ONLINE, false = OFFLINE
    private String role;
    private LocalDateTime lastSeen;
    private Set<String> chatRooms;
    private Set<String> blockedUsers;
    private Set<String> friendsList;
    private Set<String> groupsJoined;

    public UserResponse() {
        this.blockedUsers = blockedUsers;
        this.bio = bio;
        this.chatRooms = chatRooms;
        this.email = email;
        this.friendsList = friendsList;
        this.groupsJoined = groupsJoined;
        this.id = id;
        this.lastSeen = lastSeen;
        this.name = name;
        this.online = online;
        this.profilePicture = profilePicture;
        this.role = role;
        this.username = username;
    }
}

