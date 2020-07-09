package com.tensorflow.util;

import java.sql.Connection;

public class test {
public static void main(String[] args) {
	Connection connection = GetConnectionUtils.getoneConnection();
	if(connection!=null) {
		System.out.println("yeah");
	}else {
		System.out.println("noooooo");
	}
}
}
