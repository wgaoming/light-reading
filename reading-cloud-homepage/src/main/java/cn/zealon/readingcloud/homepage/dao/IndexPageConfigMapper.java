package cn.zealon.readingcloud.homepage.dao;

import cn.zealon.readingcloud.common.pojo.index.IndexPageConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 主页配置
 * @author: zealon
 * @since: 2020/4/5
 */
@Component
public interface IndexPageConfigMapper {

    /**
     * 主键查询实体
     * @param id
     * @return
     */
    IndexPageConfig selectById(Integer id);

    /***
     * 查询主页配置
     * @param pageType
     * @return
     */
    List<IndexPageConfig> findPageWithResult(Integer pageType);
}
