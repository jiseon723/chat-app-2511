package com.ll.chatApp.domain.article.articleCommemt.entity;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity {
    private String body;
    @ManyToOne(fetch = LAZY)
    private Article article;
    @ManyToOne(fetch = LAZY)
    private Member author;
}
