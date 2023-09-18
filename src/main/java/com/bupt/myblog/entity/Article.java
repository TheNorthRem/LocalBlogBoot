package com.bupt.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@TableName("Article")
public class Article {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer articleId;
    @TableField("title")
    @Schema(description = "标题")
    private String title;
    @TableField("content")
    @Schema(description = "内容")
    private String content;
    @TableField("upload_time")
    @Schema(description = "文章上传时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp uploadTime;
    @TableField("update_time")
    @Schema(description = "文章上传时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    public Article(){
        this.setUploadTime(Timestamp.valueOf(LocalDateTime.now()));
        this.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
    }
}
