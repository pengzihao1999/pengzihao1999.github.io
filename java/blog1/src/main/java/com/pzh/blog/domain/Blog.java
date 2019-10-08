package com.pzh.blog.domain;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 */

@Entity
@Table(name = "t_blog")
public class Blog {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //标题
    @Column(name = "title")
    private String title;
    //内容

    @Column(name = "content",columnDefinition="TEXT",nullable=true)
    private String content;
    //首图
    @Column(name = "first_picture")
    private String firstPicture;
    //标记 原创-转载
    @Column(name = "flag")
    private String flag;
    //浏览次数
    @Column(name = "views")
    private Integer views;
    //赞赏开启
    @Column(name = "appreciation")
    private Boolean appreciation;
    //版权开启
    @Column(name = "share_statement")
    private Boolean shareStatement;
    //评论开启
    @Column(name = "commentabled")
    private Boolean commentabled;
    //推荐开启
    @Column(name = "recommend")
    private Boolean recommend;
    //发布
    @Column(name = "published")
    private Boolean published;
    //创建时间
    @Column(name = "createTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //更新时间
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //实体类之间的联系
    //1.blog与type 一个blog对应一个type 一个type对应多个blog 多对一关系
    //在多的一端进行关系的维护，在一的一端进行关系的级联
    @ManyToOne//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="type_id")//设置在Blog表中的关联字段(外键)
    private Type type;
    //2.blog和tag
    //一个blog可以有多个标签，一个标签可以被多个blog使用
    @ManyToMany
    private List<Tag> tagList = new ArrayList<>();
    //3.blog和user
    //一个blog对应一个user,一个user对应多个博客
    @ManyToOne
    private User user;
    //3.blog和comments
    //一个blog有多个comments,一个comments对应一个博客
    @OneToMany(mappedBy = "blog")
    private List<Comment> commentList;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public Boolean getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", recommend=" + recommend +
                ", published=" + published +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Blog() {
    }
}
