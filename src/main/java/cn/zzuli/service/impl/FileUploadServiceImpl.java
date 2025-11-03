package cn.zzuli.service.impl;

import cn.zzuli.config.properties.MinioProperties;
import cn.zzuli.service.FileUploadService;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * projectName: com.atguigu.exam.service.impl
 *
 * @author: 赵伟风
 * description:
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 文件上传
     * @param folder 文件夹名称
     * @param file 文件
     * @return
     */
    @Override
    public String uploadFile(String folder, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 1.连接minio
        // 2.判断桶是否存在
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
        // 3.创建桶，并设置访问权限
        if (!bucketExists) {
            //创建桶
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            String config = """
                        {
                              "Statement" : [ {
                                "Action" : "s3:GetObject",
                                "Effect" : "Allow",
                                "Principal" : "*",
                                "Resource" : "arn:aws:s3:::%s/*" 
                              } ],
                              "Version" : "2012-10-17"
                        }
                    """.formatted(minioProperties.getBucketName());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                    .bucket(minioProperties.getBucketName())
                    .config(config)
                    .build());
        }
        // 4.上传文件
        String objectName = folder + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" +
                UUID.randomUUID().toString().replaceAll("-","")+"_"+ file.getOriginalFilename();

        log.debug("文件上传核心业务方法，处理后的文件对象名：{}",objectName);
        //putObject . 上传文件数据 .steam(文件输入流)
        //uploadObject .上传文件数据 .filename(文件的磁盘地址 c:\\)
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucketName())
                .contentType(file.getContentType())
                .object(objectName) //对象
                .stream(file.getInputStream(),file.getSize(),-1) //-1 我们不指定文件切割大小！让minio自动处理！
                .build());
        // 5.拼接回显地址
        String url = String.join("/", minioProperties.getEndPoint(), minioProperties.getBucketName(), objectName);
        log.info("文件上传核心业务，完成{}文件上传，返回地址为：{}",objectName,url);
        return url;

    }
}
