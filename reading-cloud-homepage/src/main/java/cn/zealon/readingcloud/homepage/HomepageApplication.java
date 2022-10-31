package cn.zealon.readingcloud.homepage;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"cn.zealon.readingcloud.book.feign", "cn.zealon.readingcloud.account.feign"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.zealon.readingcloud.homepage", "cn.zealon.readingcloud.common", "cn.zealon.readingcloud.book.feign", "cn.zealon.readingcloud.account.feign"})
@EnableRabbit
public class HomepageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomepageApplication.class, args);
    }

}
