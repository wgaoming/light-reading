package cn.zealon.readingcloud.book.common.config;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

/**
 * MyBatis配置
 * @author: zealon
 * @since: 2020/4/2
 */
@Configuration
@MapperScan(basePackages = "cn.zealon.readingcloud.book.dao")
public class MybatisConfig {

    /** 分页插件 */
    private PageHelper getPageHelper(){
        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");
        //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");
        //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        //切换数据源，自动解析不同数据库的分页
        properties.setProperty("autoRuntimeDialect", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
