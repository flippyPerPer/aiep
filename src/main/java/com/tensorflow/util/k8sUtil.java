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
 * k8s����util
 */
public class k8sUtil {
    /**
     * ��ʹ��ǰҪ�ȵ��ø÷���,����k8s��Ⱥ������
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
     * ����yaml�����ļ�
     *
     * @param path
     * @throws IOException
     */
    public static Object loadYaml(String path) throws IOException {
        Reader reader = new FileReader(path);
        return Yaml.load(reader);
    }
 
    /**
     * ����pod
     *
     * @param nameSpace �����ƿռ�
     * @param body      ��pod
     * @return
     * @throws ApiException
     */
    public static V1Pod createPod(String nameSpace, V1Pod body) throws ApiException {
 
        return new CoreV1Api().createNamespacedPod(nameSpace, body, true, "true", null);
 
    }
 
    /**
     * ɾ��pod
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
     * ����service
     *
     * @param nameSpace
     * @param sv
     * @throws ApiException
     */
    public static void createService(String nameSpace, V1Service sv) throws ApiException {
        new CoreV1Api().createNamespacedService(nameSpace, sv, true, "true", null);
    }
 
    /**
     * ɾ��service
     *
     * @param nameSpace
     * @param serviceName
     * @throws Exception
     */
    public static void deleteService(String nameSpace, String serviceName) throws Exception {
        new CoreV1Api().deleteNamespacedService(serviceName, nameSpace, null, null, null, null, null, null);
    }
 
    /**
     * ����deployment
     *
     * @param nameSpace
     * @param body
     * @throws ApiException
     */
    public static void createDeployment(String nameSpace, V1Deployment body) throws ApiException {
        new AppsV1Api().createNamespacedDeployment(nameSpace, body, true, "true", null);
    }
 
    /**
     * �h��namespace
     *
     * @param nameSpace
     * @param deployeName
     * @throws ApiException
     */
    public static void deleteDeployment(String nameSpace, String deployeName) throws ApiException {
        new AppsV1Api().deleteNamespacedDeployment(deployeName, nameSpace, "true", null, null, null, null, null);
    }
    
    //����չʾ��ǰ����pod�Ƿ���������
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