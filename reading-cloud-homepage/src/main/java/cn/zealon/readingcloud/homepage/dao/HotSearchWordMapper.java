package cn.zealon.readingcloud.homepage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 热搜词
 * @author: zealon
 * @since: 2020/5/29
 */
@Component
public interface HotSearchWordMapper {

    /**
     * 获取热搜词
     * @param size
     * @return
     */
    @Select("SELECT name FROM hot_search_word order by frequency desc limit #{size}")
    List<String> getHotSearchWordList(@Param("size") int size);

    @Select("SELECT name FROM hot_search_word where name=#{name}")
    String getHotSearchWord(@Param("name") String name);

    int insert(@Param("name") String name);

    int update(@Param("name") String name);
}
