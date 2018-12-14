package com.pan.blog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by FantasticPan on 2018/11/27.
 */
@Entity
@Data
public class Catalog implements Serializable {

    private static final long serialVersionUID = -2961102930218947735L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String catalogName;

    @OneToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Catalog() {
    }

    public Catalog(User user, String name) {
        this.catalogName = name;
        this.user = user;
    }
}
