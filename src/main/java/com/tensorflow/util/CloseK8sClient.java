package com.tensorflow.util;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.apis.CoreV1Api;

public class CloseK8sClient {
	public static void close(ApiClient client,CoreV1Api api) {
		if(client !=null) {
			client = null;
		}
		if(api!=null) {
			api = null;
		}
	}
}
