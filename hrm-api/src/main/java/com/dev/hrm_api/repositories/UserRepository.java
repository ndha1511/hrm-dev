package com.dev.hrm_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.hrm_api.dtos.user.UserPermDto;
import com.dev.hrm_api.schema.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Query("""
            SELECT new com.dev.hrm_api.dtos.user.UserPermDto(
                u.username,
                u.passwordHash,
                ap.app.appCode,
                p.permType
            )
                        FROM UserAppPerm uap
                        JOIN uap.user u
                        JOIN uap.appPerm ap
                        JOIN ap.perm p
                        WHERE u.username = :username AND u.isActive = true
                    """)
    List<UserPermDto> findRawPermsByUsername(@Param("username") String username);
}
