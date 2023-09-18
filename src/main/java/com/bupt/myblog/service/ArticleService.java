package com.bupt.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.myblog.entity.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {

    List<Article> listTitle();

}
