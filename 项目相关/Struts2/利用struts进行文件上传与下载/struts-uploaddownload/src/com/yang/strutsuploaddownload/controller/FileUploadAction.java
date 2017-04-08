package com.yang.strutsuploaddownload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 上传单个文件的action基类
 * 
 * 只要符合struts2的命名规范，struts2会自动加载相应的属性
 * 
 * @author Administrator
 *
 */
public class FileUploadAction extends ActionSupport
{
    
    //注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;


    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType)
    {
        this.fileContentType = fileContentType;
    }
    
    
    /**
     * action 调用的方法
     * @return
     * @throws IOException
     */
    public String upload()
    {
    	ActionContext.getContext().getSession().put("fileName", fileFileName);
    	
    	//指定上传文件的存放路径
        String root = ServletActionContext.getServletContext().getRealPath("/upload");
        
        //指定上传文件的存放路径
        String path = "I:/testUpload";
        
        try {
			FileUtils.copyFile(file, new File(path, fileFileName));
		} catch (IOException e) {
			
			e.printStackTrace();
			
			return INPUT;
		}
        
        return SUCCESS;
    }
}
