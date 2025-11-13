package com.ll.chatApp.domain.article.articleCommemt.service;

import com.ll.chatApp.domain.article.articleCommemt.entity.ArticleComment;
import com.ll.chatApp.domain.article.articleCommemt.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> findByAuthorId(Long id) {
        return articleCommentRepository.findByAuthorId(id);
    }
}
