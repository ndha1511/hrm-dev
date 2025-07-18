package com.dev.hrm_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "apps")
public class App extends BaseEntity {
    @Column(name = "app_code", nullable = false, unique = true)
    private String appCode;
    @Column(name = "app_name", nullable = false, unique = true)
    private String appName;
    @Column(name = "app_icon", nullable = false)
    private String appIcon;
    @OneToMany(mappedBy = "app", fetch = FetchType.LAZY)
    private List<AppPerm> appPerms;
    @Column(name = "parent_app_code", nullable = true)
    private String parentAppCode;
}
