package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.assertj.core.api.BDDAssumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    /**
     * 검색
     * 각 게시글 페이지로 이동
     * 페이지네이션
     * 홈 버튼 -> 게시판 페이지로 리다이렉션
     * 정렬기능
     */

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnArticleList() {
        //given

        //when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");//제목, 본문, ID, 닉네임, 해시태그

        //then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnArticle() {
        //given

        //when
        ArticleDto article = sut.searchArticle(1L);//제목, 본문, ID, 닉네임, 해시태그

        //then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        //given

        given(articleRepository.save(any(Article.class)))
                .willReturn(null);        //when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "bumjin", "title", "content", "hashtag"));
        //then
        then(articleRepository).should().save(any(Article.class));//articleRepository.save가 호출되었는지만 테스트
    }

    @DisplayName("게시글의 ID와 수정정보를 입력하면, 게시글을 수정한다.")
    @Test
    void givenArticleIdAndModifiedInfo_whenSavingArticle_thenUpdatesArticle() {
        //given
        given(articleRepository.save(any(Article.class)))
                .willReturn(null);        //when
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "hashtag"));
        //then
        then(articleRepository).should().save(any(Article.class));//articleRepository.save가 호출되었는지만 테스트
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeleteArticle() {
        //given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        sut.deleteArticle(1L);
        //then
        then(articleRepository).should().delete(any(Article.class));//articleRepository.delete가 호출되었는지만 테스트
    }

}