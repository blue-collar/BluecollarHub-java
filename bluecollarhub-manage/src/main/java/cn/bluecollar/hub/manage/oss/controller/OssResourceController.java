package cn.bluecollar.hub.manage.oss.controller;


import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.entity.oss.OssResource;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * <p>
 * 云存储资源表 前端控制器
 * </p>
 *
 * @author rick
 * @since 2018-11-30
 */
@RestController
@RequestMapping("/admin/oss/resource")
public class OssResourceController {
    @Value("${oss.tengxun.accessKey}")
    private String accessKey;

    @Value("${oss.tengxun.secretKey}")
    private String secretKey;

    @Value("${oss.tengxun.bucket}")
    private String bucket;

    @Value("${oss.tengxun.bucketName}")
    private String bucketName;

    @Value("${oss.tengxun.path}")
    private String path;

    @Value("${oss.tengxun.qianzhui}")
    private String qianzhui;

    @PostMapping("/upload")
    public Result Upload(@RequestParam(value = "file") MultipartFile file, HttpSession session) {
        if (file == null) {
            System.out.println("call Upload file == null");
            return Result.error("文件为空").put("resource", new OssResource(0, null, "文件为空"));
        }
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(bucket));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = this.bucketName;

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = null;
        String url;
        try {
            localFile = File.createTempFile("temp", null);
            file.transferTo(localFile);
            // 指定要上传到 COS 上的路径
            String key = "/" + this.qianzhui + "/" + year + "/" + month + "/" + day + "/" + newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            url = this.path + putObjectRequest.getKey();
            System.out.println("call Upload url is " + url + " Filename is " + file.getOriginalFilename());
            return Result.ok().put("resource", new OssResource(1, url, file.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("call Upload IOException：" + e.toString());
            return Result.error("IOException").put("resource", new OssResource(-1, e.getMessage(), "IOException"));
        } finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }
}
