package com.makers.chitterchallenge.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "COMMENTS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private String comment_content;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @ManyToOne(optional = true)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Chitter parent;

    private Comment() {}

    public Comment(String comment_content) {
        this.comment_content = comment_content;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }


    public Chitter getParentChitter() {
        return parent;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chitter getParent() {
        return parent;
    }

    public void setParent(Chitter parent) {
        this.parent = parent;
    }

}