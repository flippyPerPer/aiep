package com.tensorflow.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.dao.PodDao;
import com.tensorflow.dao.PodDaoImpl;
import com.tensorflow.entity.Pod;
import com.tensorflow.util.CloseK8sClient;
import com.tensorflow.util.GetK8sConection;
import com.tensorflow.util.k8sUtil;

import io.kubernetes.client.apis.CoreV1Api;

public class PodServiceImpl implements PodService {
	
	private PodDao podDao = new PodDaoImpl();

	public Pod checkAvaliablePods() {
		
		Pod pod = null;
		try {
			pod = podDao.checkAvaliablePods();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pod;
	}

	public boolean updateAllPodStatus() {
		CoreV1Api api = GetK8sConection.getK8sConnection();
		List<Pod> pods = new ArrayList<>();
		pods = k8sUtil.showPodsStatus(api);
		System.out.println("��ʼ��K8S�и������ݿ���Pod��ʵʱ���,�������¡�\n"+pods);
		CloseK8sClient.close(null, api); 
		try {
			return podDao.updateAllPodStatus(pods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePod(String podName) {
		k8sUtil.deletePod("default", podName);
		System.out.println("��K8S��ɾ�����˳���ʹ��ʱ����PodΪ��"+podName);
		try {
			return podDao.deletePod(podName);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public List<Pod> showAllPods() {
		List<Pod> pods = null;
		try {
			pods = podDao.showAllPods();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pods;
	}


}
