package com.tensorflow.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.entity.Pod;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.auth.ApiKeyAuth;
import io.kubernetes.client.models.V1Deployment;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.Yaml;
 
/**
 * k8s操作util
 */
public class k8sUtil {
    /**
     * 在使用前要先调用该方法,设置k8s集群的配置
     * @param kubeConfigPath
     * @return
     * @throws IOException
     */
    public static void setConfig(String kubeConfigPath) throws IOException {
        ApiClient client =
                ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
        Configuration.setDefaultApiClient(client);
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth BearerToken = (ApiKeyAuth) defaultClient.getAuthentication("BearerToken");
        BearerToken.setApiKey("YOUR API KEY");
 
    }
 
    /**
     * 加载yaml配置文件
     *
     * @param path
     * @throws IOException
     */
    public static Object loadYaml(String path) throws IOException {
        Reader reader = new FileReader(path);
        return Yaml.load(reader);
    }
 
    /**
     * 创建pod
     *
     * @param nameSpace ：名称空间
     * @param body      ：pod
     * @return
     * @throws ApiException
     */
    public static V1Pod createPod(String nameSpace, V1Pod body) throws ApiException {
 
        return new CoreV1Api().createNamespacedPod(nameSpace, body, true, "true", null);
 
    }
 
    /**
     * 删除pod
     *
     * @param nameSpace
     * @param podName
     */
    public static void deletePod(String nameSpace, String podName){
		try {
			new CoreV1Api().deleteNamespacedPod(podName, nameSpace, "true", null, null, null, null, null);
		} catch (Exception e) {
		}
    }
 
    /**
     * 创建service
     *
     * @param nameSpace
     * @param sv
     * @throws ApiException
     */
    public static void createService(String nameSpace, V1Service sv) throws ApiException {
        new CoreV1Api().createNamespacedService(nameSpace, sv, true, "true", null);
    }
 
    /**
     * 删除service
     *
     * @param nameSpace
     * @param serviceName
     * @throws Exception
     */
    public static void deleteService(String nameSpace, String serviceName) throws Exception {
        new CoreV1Api().deleteNamespacedService(serviceName, nameSpace, null, null, null, null, null, null);
    }
 
    /**
     * 创建deployment
     *
     * @param nameSpace
     * @param body
     * @throws ApiException
     */
    public static void createDeployment(String nameSpace, V1Deployment body) throws ApiException {
        new AppsV1Api().createNamespacedDeployment(nameSpace, body, true, "true", null);
    }
 
    /**
     * 刪除namespace
     *
     * @param nameSpace
     * @param deployeName
     * @throws ApiException
     */
    public static void deleteDeployment(String nameSpace, String deployeName) throws ApiException {
        new AppsV1Api().deleteNamespacedDeployment(deployeName, nameSpace, "true", null, null, null, null, null);
    }
    
    //用于展示当前所有pod是否正常运行
    public static List<Pod> showPodsStatus(CoreV1Api api){
    	List<Pod> pods = new ArrayList<Pod>();
    	V1PodList list = null;
		try {
			list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
		} catch (ApiException e) {
			e.printStackTrace();
		}
        for (V1Pod item : list.getItems()) {
        	pods.add(new Pod(item.getMetadata().getName(), item.getStatus().getHostIP()+":8989", item.getStatus().getPhase()));
        }
        CloseK8sClient.close(null, api);
    	return pods;
    }
    
    
//    public static void main(String[] args) throws Exception {
//        setConfig("config");
//        Reader reader = new FileReader("datax3.yaml");
//        Object load = Yaml.load(reader);
//        System.out.println(load.getClass());
//        V1Deployment d = (V1Deployment) load;
//        d.getMetadata().setName("datax-test");
//        deleteDeployment("default", d.getMetadata().getName());
// 
//    }
}