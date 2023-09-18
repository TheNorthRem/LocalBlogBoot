package com.bupt.myblog.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.myblog.entity.Article;
import com.bupt.myblog.service.ArticleService;
import com.bupt.myblog.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/Article")
@Slf4j
@Tag(name = "文章")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService service){
        this.articleService=service;
    }

    @GetMapping("/list")
    @Operation(summary = "查询全部文章")
    public JSONObject list() {
        return Result.ok(articleService.list());
    }

    @PostMapping("/upload")
    @Operation(summary = "上传文章")

    @Parameters({@Parameter(name = "title", description = "标题"),@Parameter(name="content",description = "内容")})
    public JSONObject upload(@RequestBody JSONObject article) {

       String title =article.getString("title");
       String content=article.getString("content");

       if(title.trim().length()==0){
           return Result.error("标题为空");
       }

       Article article1=new Article();
       article1.setTitle(title);
       article1.setContent(content);

       articleService.save(article1);
       return Result.ok("success");
    }

    @PostMapping("/update")
    @Operation(summary = "更新文章")

    @Parameters({@Parameter(name = "title", description = "标题"),@Parameter(name="content",description = "内容"),@Parameter(name = "Id",description = "文章ID")})
    public JSONObject update(@RequestBody JSONObject article) {

        String title =article.getString("title");
        String content=article.getString("content");
        Integer Id=article.getInteger("Id");
        if(title.trim().isEmpty()){
            return Result.error("标题为空");
        }

        Article byId = articleService.getById(Id);

        if(byId==null){
            return Result.error("文章不存在");
        }

        byId.setTitle(title);
        byId.setContent(content);
        byId.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        articleService.updateById(byId);
        return Result.ok("success");
    }

    @GetMapping("/getArticle")
    @Operation(summary = "获取文章")
    @Parameter(name = "Id",description = "文章Id")
    public JSONObject getArticle(@RequestParam("Id") Integer Id){
        Article byId = articleService.getById(Id);
        if(byId==null) return Result.error("文章不存在");
        return Result.ok(byId);
    }

    @GetMapping("/search")
    @Operation(summary = "查询全部文章标题")
    public JSONObject listTitle() {
        return Result.ok(articleService.listTitle());
    }

}
