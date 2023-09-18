package com.bupt.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("select article_Id,title,upload_time,update_time from Article order by upload_time desc ")
    List<Article> getTitles();
}
