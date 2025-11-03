package cn.zzuli.config.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 读取application中的minio的属性
 * @Author: 谢天驰
 * @Date: 2020/3/27 16:05
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
