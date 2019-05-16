package com.suchuner.crm.utils;

import java.util.UUID;

public class FileNameUtils {

	public static String getUuidFileName(String uploadFileFileName) {
		int p = uploadFileFileName.lastIndexOf(".");//获取最后一个.的位置
		String extions = uploadFileFileName.substring(p);//一最后一个.的索引截取文件的扩展名
		//用UUID类得到随机数并将其字符串化,然后将包含的-替换为空,最后拼接文件的扩展名
		return UUID.randomUUID().toString().replace("-", "")+extions;
	}

	public static String getDirsForFile(String fileName) {
		int code = fileName.hashCode();
		int dir1=code & 0xf;//作为一级目录
		int code2 =code >>> 4;//向右移四位
		int dir2 = code2 & 0xf;//作为二级目录
		return "/"+dir1+"/"+dir2+"/";
	}
	
}
