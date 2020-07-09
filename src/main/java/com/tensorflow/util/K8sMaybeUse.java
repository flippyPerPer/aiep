package com.tensorflow.util;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.models.V1Deployment;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1beta1DaemonSet;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.tensorflow.util.k8sUtil;
 
public class K8sMaybeUse {
	public static void main(String[] args) throws Exception {
 
        //在项目下可以直接写文件名
        String kubeConfigPath = "D:\\workspace\\k8sCome\\config";
        //加载k8s,config
        ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
        //将加载config的client设置为默认的client
        Configuration.setDefaultApiClient(client);
        //创建一个api
        CoreV1Api api = new CoreV1Api();
        
//        k8sUtil.showPodsStatus(api);
        
//        //创建一个service
//        Reader reader = new FileReader("nginx-service.yaml");
//        Object load = Yaml.load(reader);
//        System.out.println(load.getClass());
//        V1Service test = (V1Service) load;
//        k8sUtil.createService("default", test);
//        
//        //创建一个Deployment
//        Reader reader = new FileReader("nginx-deployment.yaml");
//        Object load = Yaml.load(reader);
//        System.out.println(load.getClass());
//        V1Deployment test = (V1Deployment) load;
//        k8sUtil.createDeployment("default", test);
        
        //打印当前所有pod
        V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
        	System.out.println(item.getMetadata().getName());
        }
        
//        //删除一个pod	
//        nowPod = list.getItems().get(1).getMetadata().getName();
//        System.out.println("准备删除的pod:\n" + nowPod + "\n8s后显示新的pod列表");
//        k8sUtil.deletePod("default", nowPod);
//        //打印所有的pod
//        System.out.println("删除完pod后的pod列表：");
//        list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
//        for (V1Pod item : list.getItems()) {
//            System.out.println(item.getMetadata().getName());
//        }
          CloseK8sClient.close(client, api);
    }
}
