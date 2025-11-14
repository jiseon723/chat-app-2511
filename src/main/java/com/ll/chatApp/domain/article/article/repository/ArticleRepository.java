package com.ll.chatApp.domain.article.article.repository;

import com.ll.chatApp.domain.article.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByTitleContainingOrContentContaining(String kw, String kw_, Pageable pageable);

    Page<Article> findByTitleContaining(String kw, Pageable pageable);

    Page<Article> findByContentContaining(String kw, Pageable pageable);
}