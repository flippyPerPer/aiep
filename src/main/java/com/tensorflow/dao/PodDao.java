package com.tensorflow.dao;

import java.sql.SQLException;
import java.util.List;

import com.tensorflow.entity.Pod;

public interface PodDao {
	public Pod checkAvaliablePods() throws SQLException ;
	
	public boolean updatePodStatus(String podIP,long endTime) throws SQLException;
	
	public boolean updateAllPodStatus(List<Pod> pods) throws SQLException;
	
	public List<Pod> showAllPods() throws SQLException;
	
	public boolean deletePod(String podName) throws SQLException;
}
