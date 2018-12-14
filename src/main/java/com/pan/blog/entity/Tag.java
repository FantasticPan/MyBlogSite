package com.pan.blog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by FantasticPan on 2018/12/8.
 */
@Entity
@Data
public class Tag implements Serializable {

    private static final long serialVersionUID = 7008280215502234200L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String tagName;

    public Tag() {
    }

    public Tag(@Size(min = 2, max = 30) String tagName) {
        this.tagName = tagName;
    }
}
