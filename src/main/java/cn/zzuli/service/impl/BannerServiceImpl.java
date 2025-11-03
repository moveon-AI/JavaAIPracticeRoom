package cn.zzuli.service.impl;


import cn.zzuli.entity.Banner;
import cn.zzuli.mapper.BannerMapper;
import cn.zzuli.service.BannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.minio.errors.*;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 轮播图服务实现类
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    /**
     * 上传轮播图图片
     *
     * @param file 图片文件
     * @return 图片URL
     */
    @Override
    public String uploadBannerImage(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 1.文件非空校验
        if (file == null || file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空,上传失败");
        }
        // 2.文件类型校验
        String contentType = file.getContentType();
        if (  ObjectUtils.isEmpty(contentType) || !contentType.startsWith("image/")) {
            throw new RuntimeException("上传文件类型错误,上传失败");
        }
        // 3.调用文件上传服务
        String imageUrl = fileUploadService.uploadFile("banner", file);
        // 4.回显地址信息
        return imageUrl;
    }

}