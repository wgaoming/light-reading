package cn.zealon.readingcloud.account.dao;

import cn.zealon.readingcloud.common.pojo.account.User;
import org.springframework.stereotype.Component;

/**
 * 用户
 * @author: zealon
 * @since: 2020/4/10
 */
@Component
public interface UserMapper {

    int insert(User user);

    int updateByLoginName(User user);

    User selectByLoginName(String loginName);

}
