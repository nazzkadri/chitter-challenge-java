package com.makers.chitterchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "CHITTERS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)

public class Chitter {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long chitter_id;
        private String content;

        @Column(nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdAt;

        @ManyToOne(optional = true, fetch = FetchType.LAZY)
        private User author;

        @OneToMany(mappedBy = "parent")
        private List<Comment> commentList = new ArrayList<>();

        public void addComment(Comment comment) {
            this.commentList.add(comment);
            comment.setParent(this);
        }

        private Chitter() {}

    public Long getChitter_id() {
        return chitter_id;
    }

    public void setChitter_id(Long chitter_id) {
        this.chitter_id = chitter_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Chitter(String content) {
            this.content = content;
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

//    @Override
//    public String toString(){
//        return
//    }


}
