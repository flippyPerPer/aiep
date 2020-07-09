package com.tensorflow.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
 
public class GetK8sConection {
	public static CoreV1Api getK8sConnection() {
        //在项目下可以直接写文件名
        String kubeConfigPath = "D:\\workspace\\k8sCome\\config";
        //加载k8s,config
        ApiClient client = null;
		try {
			client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //将加载config的client设置为默认的client
        Configuration.setDefaultApiClient(client);
        //创建一个api
        CoreV1Api api = new CoreV1Api();
        return api;
}
}
