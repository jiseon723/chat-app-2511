package com.ll.chatApp.domain.article.article.service;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.domain.member.member.service.MemberService;
import com.ll.chatApp.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private MemberService memberService;

    @DisplayName(("글 쓰기"))
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1L, "제목", "내용");
        Article article = writeRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }

    @DisplayName(("1번 글 가져오기"))
    @Test
    void t2() {
        Article article = articleService.findById(1L).get();
        assertThat(article.getTitle()).isEqualTo("제목1");
    }

    @DisplayName(("1번 글 작성자의 userName은 user1이다."))
    @Test
    void t3() {
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();
        assertThat(author.getAuthor()).isEqualTo("user1");
    }

    @DisplayName(("1번 글의 제목을 수정한다."))
    @Test
    void t4() {
        Article article = articleService.findById(1L).get();
        articleService.modify(article, "수정된 제목", "수정된 내용");
        Article article1 = articleService.findById(1L).get();

        assertThat(article1.getTitle()).isEqualTo("수정된 제목");;
    }

    @DisplayName(("2번 글의 댓글을 추가한다."))
    @Test
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(1L).get();

        article2.addComment(member1, "댓긓");
    }
}