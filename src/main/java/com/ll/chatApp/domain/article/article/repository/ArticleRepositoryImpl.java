package com.ll.chatApp.domain.article.article.repository;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.ll.chatApp.domain.article.article.entity.QArticle.article;

@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Article> search(List<String> kwTypes, String kw, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        if (kwTypes.contains("authorUsername") && kwTypes.contains("title") && kwTypes.contains("content")) {
            builder.and(
                    article.title.containsIgnoreCase(kw)
                            .or(article.content.containsIgnoreCase(kw)) //containsIgnoreCase 대소문자 구분없애기
                            .or(article.author.username.containsIgnoreCase(kw))
            );
        }

        JPAQuery<Article> articlesQuery = jpaQueryFactory
                .select(article)
                .from(article)
                .where(builder);

        for (Sort.Order o : pageable.getSort()) { //정렬
            PathBuilder pathBuilder = new PathBuilder(article.getType(), article.getMetadata());
            articlesQuery.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(o.getProperty())));
        }                               //OrderSpecifier: 정렬기준이 바뀌어도 이 코드는 그대로 실행

        articlesQuery.offset(pageable.getOffset()).limit(pageable.getPageSize());

        JPAQuery<Long> totalQuery = jpaQueryFactory //조건에 맞는 데이터가 총 몇개인지
                .select(article.count())
                .from(article)
                .where(builder);

        return PageableExecutionUtils.getPage(articlesQuery.fetch(), pageable, totalQuery::fetchOne);
    }
}