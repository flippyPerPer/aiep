package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.entity.Pod;
import com.tensorflow.util.CloseResourceUtils;
import com.tensorflow.util.GetConnectionUtils;
import com.tensorflow.util.GetK8sConection;
import com.tensorflow.util.k8sUtil;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;

public class PodDaoImpl implements PodDao {

	
	public Pod checkAvaliablePods() throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "SELECT Pod_Name,Pod_IP FROM `pods` WHERE Is_Using = 0 AND Pod_Status = 'Running'";
		PreparedStatement read = connection.prepareStatement(sql);
		ResultSet resultSet = read.executeQuery();
		Pod pod = new Pod();
		
		if(resultSet.first() == true) {
			pod.setPodName(resultSet.getString("Pod_Name"));
			pod.setPodIP(resultSet.getString("Pod_IP"));
			pod.setEndTime(System.currentTimeMillis()+30000);
		}else {
			System.out.println("没空闲Pod可用了");
			CloseResourceUtils.close(connection, read, resultSet);
			return null;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		updatePodStatus(pod.getPodIP(),pod.getEndTime());
		return pod;
	}

	public boolean updatePodStatus(String podIP,long endTime) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "UPDATE pods SET Is_Using = 1,End_time = ? WHERE Pod_IP = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setLong(1, endTime);
		read.setString(2, podIP);
		int executeUpdate = read.executeUpdate();
		if (executeUpdate>0) {
			CloseResourceUtils.close(connection, read, null);
			return true;
		}
		CloseResourceUtils.close(connection, read, null);
		return false;
	}
	
	public boolean updateAllPodStatus(List<Pod> pods) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "UPDATE pods SET Pod_Status = ?,Pod_Name = ? WHERE Pod_IP = ?";
		PreparedStatement read = null;
		int executeUpdate;
		for (Pod pod : pods) {
			read = connection.prepareStatement(sql);
			read.setString(1, pod.getPodStatus());
			read.setString(2, pod.getPodName());
			read.setString(3, pod.getPodIP());
			executeUpdate = read.executeUpdate();
			if (executeUpdate>0) {
				continue;
			}else {
				CloseResourceUtils.close(connection, read, null);
				return false;
			}
		}
		CloseResourceUtils.close(connection, read, null);
		if (pods != null) {
			return true;
		}
		return false;
	}
	
	public List<Pod> showAllPods() throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "SELECT * FROM `pods` WHERE Pod_Status = 'Running'";
		PreparedStatement read = connection.prepareStatement(sql);
		ResultSet resultSet = read.executeQuery();
		List<Pod> pods = new ArrayList<>();
		Pod pod = null;
		while(resultSet.next()) {
			pod = new Pod(resultSet.getString("Node_name"), resultSet.getString("Pod_Name"), resultSet.getString("Pod_IP"), 
					resultSet.getInt("Is_Using"), resultSet.getString("Pod_Status"), resultSet.getLong("End_Time"));
			pods.add(pod);
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return pods;
	}

	public boolean deletePod(String podName) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "UPDATE pods SET Pod_Status = ' ',Pod_Name = ' ',End_Time = 0,Is_Using = 0 WHERE Pod_Name = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, podName);
		int excuteUpdate = read.executeUpdate();
		if(excuteUpdate>0) {
			CloseResourceUtils.close(connection, read, null);
			return true;
		}else {
			CloseResourceUtils.close(connection, read, null);
			return false;
		}
	}



}
