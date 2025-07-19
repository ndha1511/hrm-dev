package com.dev.hrm_api.models;

import java.util.List;

import com.dev.hrm_api.models.enums.PermEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "perms")
public class Perm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "perm_name", nullable = false, unique = true)
    private String permName;
    @Column(name = "perm_value", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PermEnum permValue;
    @OneToMany(mappedBy = "perm", fetch = FetchType.LAZY)
    private List<AppPerm> appPerms;

}
