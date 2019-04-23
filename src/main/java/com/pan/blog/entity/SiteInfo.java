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
    private Long visitSize;

    public SiteInfo() {
    }

    public SiteInfo(Long articleNum, int tagNum, int catalogNum, int runDays,Long visitSize) {
        this.articleNum = articleNum;
        this.tagNum = tagNum;
        this.catalogNum = catalogNum;
        this.runDays = runDays;
        this.visitSize = visitSize;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Long articleNum) {
        this.articleNum = articleNum;
    }

    public int getTagNum() {
        return tagNum;
    }

    public void setTagNum(int tagNum) {
        this.tagNum = tagNum;
    }

    public int getCatalogNum() {
        return catalogNum;
    }

    public void setCatalogNum(int catalogNum) {
        this.catalogNum = catalogNum;
    }

    public int getRunDays() {
        return runDays;
    }

    public void setRunDays(int runDays) {
        this.runDays = runDays;
    }

    public Long getVisitSize() {
        return visitSize;
    }

    public void setVisitSize(Long visitSize) {
        this.visitSize = visitSize;
    }
}
