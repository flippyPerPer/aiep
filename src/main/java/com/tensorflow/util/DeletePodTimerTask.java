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
		System.out.println("调用每30S一次的计时器，当前数据库中的pod情况为：\n"+pods);
		for (Pod pod : pods) {
			if (pod.getEndTime()!=0 && pod.getEndTime() < System.currentTimeMillis() ) {
				podService.deletePod(pod.getPodName());
				System.out.println("计时器自动删除数据库中使用超时的Pod为：\n"+pod);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				podService.updateAllPodStatus();
				System.out.println("在PodServiceImpl里输出从K8S中查找到的当前所有pod信息,准备对所有数据进行更新。");
			}
		}
	}

}
