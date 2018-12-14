package com.pan.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by FantasticPan on 2018/12/9.
 */
@Data
@Entity
public class SiteInfo implements Serializable {

    private static final long serialVersionUID = -7073708910727778404L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleNum;
    private int tagNum;
    private int catalogNum;
    private int runDays;
    @Column(columnDefinition = "BIGINT default 0")
    private Long visitSize;

    public SiteInfo() {
    }

    public SiteInfo(Long articleNum, int tagNum, int catalogNum, int runDays) {
        this.articleNum = articleNum;
        this.tagNum = tagNum;
        this.catalogNum = catalogNum;
        this.runDays = runDays;
    }
}
