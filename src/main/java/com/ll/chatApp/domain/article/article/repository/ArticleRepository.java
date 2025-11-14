package com.ll.chatApp.domain.article.article.repository;

import com.ll.chatApp.domain.article.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByAuthor_usernameOrTitleContainingOrContentContaining(String kw, String kw_, String kw__, Pageable pageable);

    Page<Article> findByTitleContaining(String kw, Pageable pageable);

    Page<Article> findByContentContaining(String kw, Pageable pageable);

    Page<Article> findByAuthor_usernameContaining(String kw, Pageable pageable);
}