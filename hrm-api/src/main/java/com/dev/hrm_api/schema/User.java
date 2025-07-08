package com.dev.hrm_api.schema;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", indexes = @Index(columnList = "uid"))
public class User extends BaseEntity {
    @Column(name = "uid", nullable = false, unique = true, columnDefinition = "UUID")
    private UUID uid;
    @Column(name = "username", nullable = false, columnDefinition = "VARCHAR(255)")
    private String username;
    @Column(name = "full_name", nullable = false, columnDefinition = "VARCHAR(255)")
    private String fullName;
    @Column(name = "password_hash", nullable = false, columnDefinition = "VARCHAR(255)")
    private String passwordHash;
    @Column(name = "email", nullable = true, columnDefinition = "VARCHAR(255)")
    private String email;
    @Column(name = "phone_number", nullable = true, columnDefinition = "VARCHAR(10)")
    private String phoneNumber;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserAppPerm> userAppPerms;

}
