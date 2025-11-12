package com.ll.chatApp.domain.article.articleCommemt.entity;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity {
    private String body;
    @ManyToOne
    private Article article;
    @ManyToOne
    private Member author;
}
