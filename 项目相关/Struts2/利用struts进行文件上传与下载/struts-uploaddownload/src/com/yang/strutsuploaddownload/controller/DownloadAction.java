package com.yang.strutsuploaddownload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 下载单个文件的action基类
 * 
 * 使用该stream result-type有一个非常奇怪的bug，
 * inputName貌似必须是两个或两个以上的词组，单个单词只能用file
 * 
 * @author Administrator
 *
 */
public class DownloadAction extends ActionSupport {
	
	private InputStream downloadFile;

	public InputStream getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String download(){
		try {
			this.downloadFile = new FileInputStream("I:/bootstrap(simple version).zip");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return NONE;
	}
	
	

}
