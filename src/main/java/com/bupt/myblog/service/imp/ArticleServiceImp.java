package com.bupt.myblog.service.imp;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.myblog.entity.Article;
import com.bupt.myblog.mapper.ArticleMapper;
import com.bupt.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    private ArticleMapper mapper;
    @Autowired
    public ArticleServiceImp(ArticleMapper mapper){
        this.mapper=mapper;
    }


    @Override
    public List<Article> listTitle() {
        return mapper.getTitles();
    }
}
