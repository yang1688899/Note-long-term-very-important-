package com.yang.strutsuploaddownload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 上传多个文件的action基类
 * 多文件上传和单文件上传原理一样，单文件上传过去的是单一的File，
 * 多文件上传过去的就是一个List<File>集合或者是一个File[]数组
 * 
 * 只要符合struts2的命名规范，struts2会自动加载相应的属性
 * 
 * @author Administrator
 *
 */
public class FileUploadMultiAction extends ActionSupport {
	
    
		//这里用List来存放上传过来的文件，file同样指的是临时文件夹中的临时文件，而不是真正上传过来的文件
	    private List<File> file;
	    
	    //这个List存放的是文件的名字，和List<File>中的文件相对应
	    private List<String> fileFileName;
	    
	    private List<String> fileContentType;

		public List<File> getFile() {
			return file;
		}

		
		public void setFile(List<File> file) {
			this.file = file;
		}

		public List<String> getFileFileName() {
			return fileFileName;
		}

		public void setFileFileName(List<String> fileFileName) {
			this.fileFileName = fileFileName;
		}

		public List<String> getFileContentType() {
			return fileContentType;
		}

		public void setFileContentType(List<String> fileContentType) {
			this.fileContentType = fileContentType;
		}

		/**
		 * action调用的method
		 * @return
		 */
		public String uploadMulti()
	    {
			String root = ServletActionContext.getServletContext().getRealPath("/upload");
	        
			ActionContext.getContext().getSession().put("fileNames", fileFileName);
	    	
	    	for (int index=0; index<file.size(); index++){
	    		
	    		try {
					FileUtils.copyFile(file.get(index), new File(root, fileFileName.get(index)));
				} catch (IOException e) {
					
					e.printStackTrace();
					
					return INPUT;
				}
	    	}
	    	
	        return SUCCESS;
	    }

}
