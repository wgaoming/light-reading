package cn.zealon.readingcloud.account.dao;

import cn.zealon.readingcloud.common.pojo.account.UserLikeSee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户喜欢
 * @author: zealon
 * @since: 2020/4/14
 */
@Component
public interface UserLikeSeeMapper {

    int deleteByUserIdAndBookId(@Param("userId") Integer userId,
                                @Param("bookId") String bookId);

    int insert(UserLikeSee userLikeSee);

    int selectCountByUserAndBookId(@Param("userId") Integer userId,
                                   @Param("bookId") String bookId);

    List<UserLikeSee> findPageWithResult(@Param("userId") Integer userId);

    Integer findPageWithCount(@Param("bookId") String bookId);
}
