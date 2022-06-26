package com.imnu.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author WenWangXin
 * @create 2022-06-26-22:40
 */
public class FileService {

    /**
     * 上传文件
     * @param file 文件名称
     * @return string
     */
    public String fileUpdate(CommonsMultipartFile file, HttpServletRequest request) {
        // 使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件的扩展名
        String ext = FilenameUtils.getExtension(file
                .getOriginalFilename());
        //上传路径保存设置
        String path = request.getSession().getServletContext()
                //这个是项目out文件夹下的upload路径
                .getRealPath("/upload");
        System.out.println(path+"===============");
        File realPath = new File(path);
        if (!realPath.exists()){
            //如果改路径下没有/upload的文件夹，就创建一个
            realPath.mkdir();
        }
        //把文件以指定的名字写到指定的位置
        try {
            file.transferTo(new File(path + "/" + name + "." + ext));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //下面是要保存在数据的库的路径==》upload/0d8a59b4ee3645b59461e34d2e176442.png
        String imgAddress="upload/" + name + "." + ext;

        return imgAddress;
    }
}
