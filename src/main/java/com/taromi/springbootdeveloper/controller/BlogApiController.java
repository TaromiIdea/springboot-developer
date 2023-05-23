package com.taromi.springbootdeveloper.controller;

import com.taromi.springbootdeveloper.domain.Article;
import com.taromi.springbootdeveloper.dto.AddArticleRequest;
import com.taromi.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // http response body에 객체 데이터를 json 형식으로 반환하는 컨트롤러
public class BlogApiController {
    private final BlogService blogService;

    // HTTP 메서드가 POST 일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
