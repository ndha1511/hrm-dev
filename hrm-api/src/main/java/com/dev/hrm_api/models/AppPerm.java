package com.dev.hrm_api.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "app_perms")
public class AppPerm extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_code", nullable = false, referencedColumnName = "app_code")
    private App app;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perm_id", nullable = false)
    private Perm perm;
    @OneToMany(mappedBy = "appPerm", fetch = FetchType.LAZY)
    private List<UserAppPerm> userAppPerms;
    @OneToMany(mappedBy = "appPerm", fetch = FetchType.LAZY)
    private List<RoleAppPerm> roleAppPerms;

}
