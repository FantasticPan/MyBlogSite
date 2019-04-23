package com.pan.blog.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by FantasticPan on 2018/11/23.
 */
@Entity
//@Data
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // 映射为字段，值不能为空
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
