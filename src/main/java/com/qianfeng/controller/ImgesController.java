package com.qianfeng.controller;

import com.qianfeng.beans.Imges;
import com.qianfeng.dao.ImgesDao;
import com.qianfeng.util.FileUtils;
import com.qianfeng.util.IdUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.MulticastSocket;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
@RestController
public class ImgesController {
    @Resource
    private ImgesDao dao;
    @RequestMapping("addimges")
    public  String addimges(@RequestParam("file")final MultipartFile[] files, @RequestParam Map<String,String> map) {

        for (int i = 0; i < files.length; i++) {
            final MultipartFile file = files[i];
            String filename = file.getOriginalFilename();
            final String path = "D:/新建文件夹/day61/uploadimges/" + filename;
            FileUtils.pool.execute(new Runnable() {
                public void run() {
                    try {
                        file.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Imges img = new Imges();
            img.setId(IdUtils.createId());
            img.setImgname(path);
            img.setCommodityid(map.get("commodityId"));
            try {
                dao.addimges(img);
            } catch (Exception e) {
                return "保存失败";
            }
        }
        return "保存成功";
    }
}
