package cn.zealon.readingcloud.homepage.dao;

import cn.zealon.readingcloud.homepage.domain.SearchBookItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchBookItemDao extends ElasticsearchRepository<SearchBookItem,Long> {
}
