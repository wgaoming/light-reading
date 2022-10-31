package cn.zealon.readingcloud.homepage.dao;

import cn.zealon.readingcloud.common.pojo.index.IndexBanner;
import org.springframework.stereotype.Component;

/**
 * Banner
 * @author: zealon
 * @since: 2020/4/6
 */
@Component
public interface IndexBannerMapper {

    IndexBanner selectById(Integer id);

}
