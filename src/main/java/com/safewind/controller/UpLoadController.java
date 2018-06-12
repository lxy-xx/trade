package com.safewind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * Created by qt on 2018/6/2.
 */
@Controller
public class UpLoadController {
    @RequestMapping(value = "/upLoad",method = RequestMethod.GET)
    public String uploadForm(){
        return "upLoad";
    }

    @RequestMapping(value = "/upLoadDo",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        String fileName = new Date().getTime()+"+"+file.getName();
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
        return "uploadResult";
    }
}
