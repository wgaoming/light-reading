package cn.zealon.readingcloud.homepage.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Book搜索结果项
 * @author: zealon
 * @since: 2020/5/29
 */
@Data
@Document(indexName = "index")
public class SearchBookItem {
    /**
     * 图书id
     */
    @Id
    private String bookId;

    /**
     * 图书名称
     */
    @Field(type= FieldType.Text)
    private String bookName;

    /**
     * 图书评分
     */
    @Field(type= FieldType.Integer)
    private Integer bookScore;

    /**
     * 封面
     */
    @Field(type= FieldType.Keyword)
    private String imgUrl;

    /**
     * 作者名称
     */
    @Field(type= FieldType.Text)
    private String author;

    /**
     * 简介
     */
    @Field(type= FieldType.Text)
    private String introduction;

    /**
     * 分类
     */
    @Field(type= FieldType.Integer)
    private Integer dicCategory;
    @Field(type= FieldType.Keyword)
    private String categoryName;
}
