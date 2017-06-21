package com.taotao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.utils.FastDFSClient;

/**
 * 图片上传控制器
 * 
 * @author x8529
 *
 */
@Controller
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	@RequestMapping("pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile) {
		try {
			// 接收上传的文件

			// 获取扩展名
			String fileName = uploadFile.getOriginalFilename();
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// 上传到图片服务器
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resources/client.conf");
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			url = IMAGE_SERVER_URL + url;
			// 响应上传图片地 url路径
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.objectToJson(result);
		}

	}

}
