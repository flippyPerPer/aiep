package com.tensorflow.util;

import java.sql.SQLException;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.tensorflow.dao.PodDaoImpl;
import com.tensorflow.entity.Pod;
import com.tensorflow.service.PodService;
import com.tensorflow.service.PodServiceImpl;

public class DeletePodTimerTask extends TimerTask {
	public DeletePodTimerTask() {
	}
	public DeletePodTimerTask(ServletContext servletContext) {
	}

	public void run() {
		List<Pod> pods = null;
		PodService podService = new PodServiceImpl();
		pods = podService.showAllPods();
		System.out.println("����ÿ30Sһ�εļ�ʱ������ǰ���ݿ��е�pod���Ϊ��\n"+pods);
		for (Pod pod : pods) {
			if (pod.getEndTime()!=0 && pod.getEndTime() < System.currentTimeMillis() ) {
				podService.deletePod(pod.getPodName());
				System.out.println("��ʱ���Զ�ɾ�����ݿ���ʹ�ó�ʱ��PodΪ��\n"+pod);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				podService.updateAllPodStatus();
				System.out.println("��PodServiceImpl�������K8S�в��ҵ��ĵ�ǰ����pod��Ϣ,׼�����������ݽ��и��¡�");
			}
		}
	}

}
