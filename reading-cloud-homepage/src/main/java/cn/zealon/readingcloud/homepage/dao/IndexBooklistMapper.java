package cn.zealon.readingcloud.homepage.dao;

import cn.zealon.readingcloud.common.pojo.index.IndexBooklist;
import org.springframework.stereotype.Component;

/**
 * 书单配置
 * @author: zealon
 * @since: 2020/4/6
 */
@Component
public interface IndexBooklistMapper {

    IndexBooklist selectById(Integer id);
}
