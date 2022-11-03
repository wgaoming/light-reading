package cn.zealon.readingcloud.homepage.common.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    @Bean
    RestHighLevelClient client(){
        RestClientBuilder builder= RestClient.builder(new HttpHost("localhost",9200,"http"));
        return new RestHighLevelClient(builder);

    }
}
