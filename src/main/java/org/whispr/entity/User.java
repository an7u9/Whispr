package org.whispr.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
// specifies the name of the collection in MongoDB.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    private String name;
    private String bio;
    private String profilePicture;
    private String status = "OFFLINE";
    private String role;
    private LocalDateTime lastSeen = LocalDateTime.now();
    private Set<String> chatRooms = new HashSet<>();
    private Set<String> blockedUsers = new HashSet<>();
    private Set<String> friendsList = new HashSet<>();
    private Set<String> groupsJoined = new HashSet<>();
}
