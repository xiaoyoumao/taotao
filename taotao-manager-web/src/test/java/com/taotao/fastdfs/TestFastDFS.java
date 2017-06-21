package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

public class TestFastDFS {
	@Test
	public void upLoadFile() throws Exception {
		// 1.添加jar包
		// 2.创建一个配置文件，配置tracker服务器地址
		// 3.加载配置文件
		ClientGlobal.init("E:/git/taotao/taotao-manager-web/src/main/resources/resources/client.conf");
		// 4.创建一个trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 5.使用TrackerClient对象获得trackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 6.创建一个StorageServer的引用null就可以了
		StorageServer storageServer = null;
		// 7.创建一个StrorageClient对象，trackerserver，StorageServer两个参数。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 8.使用StorageClient对象上传
		String[] strings = storageClient.upload_file("K:/1.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void upLoadFile1() throws Exception {
		FastDFSClient client = new FastDFSClient(
				"E:/git/taotao/taotao-manager-web/src/main/resources/resources/client.conf");
		String uploadFile = client.uploadFile("K:/1.jpg");
		System.out.println(uploadFile);
	}

}
