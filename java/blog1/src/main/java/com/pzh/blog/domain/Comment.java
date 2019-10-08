package com.pzh.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //昵称
    @Column(name = "nickname")
    private String nickname;
    //邮箱
    @Column(name = "email")
    private String email;
    //评论内容
    @Column(name = "content")
    private String content;
    //头像
    @Column(name = "avatar")
    private String avatar;
    //评论提交时间
    @Column(name = "create_time")
    private Date createTime;

    //关系对应
    @ManyToOne
    private Blog blog;
    //一个父级Comment含有多个子级Comment
    //一个子级Comment对应一个父级Comment

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> sonComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getSonComments() {
        return sonComments;
    }

    public void setSonComments(List<Comment> sonComments) {
        this.sonComments = sonComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blog=" + blog +
                ", sonComments=" + sonComments +
                ", parentComment=" + parentComment +
                '}';
    }

    public Comment() {
    }
}
