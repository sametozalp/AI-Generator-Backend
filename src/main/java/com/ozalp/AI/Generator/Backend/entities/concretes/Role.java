package com.ozalp.AI.Generator.Backend.entities.concretes;

import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;
import com.ozalp.AI.Generator.Backend.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "name", unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
