package com.tensorflow.service;

import java.util.List;

import com.tensorflow.entity.Pod;

public interface PodService {
	public Pod checkAvaliablePods();
	
	public boolean updateAllPodStatus();
	
	public boolean deletePod(String podName);
	
	public List<Pod> showAllPods();
}
