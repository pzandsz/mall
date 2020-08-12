package com.macro.mall.search.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 搜索中的商品信息
 * Created by macro on 2018/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "pms", type = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    /**
     * 货号
     * keyword类型的字段只能通过精确值搜索到
     */
    @Field(type = FieldType.Keyword)
    private String productSn;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 商品分类id
     */
    private Long productCategoryId;

    /**
     * 商品分类名称
     */
    @Field(type = FieldType.Keyword)
    private String productCategoryName;

    /**
     * 图片
     */
    private String pic;

    /**
     * 商品名称
     * @Field(analyzer = "ik_max_word",type = FieldType.Text):
     *      当一个字段需要被全文搜索，可以设置为text类型，设置成text类型后，
     *      该字段内容会被分析，在生成倒排索引之前，字符串会被分析器分成一个个词项
     *
     *      IK分词器有两种分词模式：ik_max_word和ik_smart模式。
     *      ik_max_word:将文本做最细粒度的拆分
     *      ik_smart_word:将文本做最粗粒度的拆分
     *
     *      索引时用ik_max_word,搜索时用ik_smart_word
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;

    /**
     * 副标题
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;

    /**
     * 关键字
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 新品状态
     */
    private Integer newStatus;

    /**
     * 推荐状态
     */
    private Integer recommandStatus;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 促销类型
     */
    private Integer promotionType;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 商品属性列表
     * FieldType.Nested:嵌套类型，object中的一个特例，可以让array类型的
     * Object独立索引和查询
     */
    @Field(type =FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}
