package com.dev.hrm_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.hrm_api.dtos.user.UserPermDto;
import com.dev.hrm_api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Query("""
               SELECT new com.dev.hrm_api.dtos.user.UserPermDto(ap.appCode, SUM(p.permValue))
               FROM UserAppPerm uap
               JOIN uap.appPerm ap
               JOIN ap.perm p
               JOIN uap.user u
               WHERE u.username = :username
               GROUP BY ap.appCode
            """)
    List<UserPermDto> findRawPermsByUsername(@Param("username") String username);
}
