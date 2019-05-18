package com.pan.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Blog 实体
 * Created by FantasticPan on 2018/11/25.
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Blog implements Serializable {

    private static final long serialVersionUID = 581304626074441455L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 2, max = 200)
    @Column(nullable = false, length = 1000) //映射为字段，值不能为空
    private String title;

    @Size(min = 2, max = 200)
    @Column(nullable = false, length = 1000) //映射为字段，值不能为空
    private String summary;

    @Lob                              //大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY)    //懒加载
    @Size(min = 2)
    @Column(nullable = false)         //映射为字段，值不能为空
    private String content;

    @Lob                              //大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY)    //懒加载
    @Size(min = 2)
    @Column(nullable = false)         //映射为字段，值不能为空
    private String htmlContent;


    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")           //映射为字段，值不能为空
    //@org.hibernate.annotations.CreationTimestamp  //由数据库自动创建时间
    private Date createTime;

    //@Column(columnDefinition = "TIMESTAMP")
    private Date updateTime;

    @Column(name = "readSize", columnDefinition = "INT default 0")
    private Integer readSize;    //访问量、阅读量

    @Column(name = "commentSize", columnDefinition = "INT default 0")
    private Integer commentSize; //评论量

    @Column(name = "voteSize", columnDefinition = "INT default 0")
    private Integer voteSize;    //点赞量

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "blog_tag", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags;

    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String catalog;
    private String image;

    public Blog() {
        this.readSize = 0;
        this.commentSize = 0;
        this.voteSize = 0;
    }

    public Blog(@Size(min = 2, max = 200) String title,
                @Size(min = 2, max = 200) String summary,
                @Size(min = 2) String content,
                @Size(min = 2) String htmlContent,
                Set<Tag> tags,
                String image) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.htmlContent = htmlContent;
        this.tags = tags;
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public Integer getVoteSize() {
        return voteSize;
    }

    public void setVoteSize(Integer voteSize) {
        this.voteSize = voteSize;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
