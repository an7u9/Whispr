package org.whispr.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    private String id;
    private ERole role;

    public Role(ERole role) {
        this.role = role;
    }

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }
}
