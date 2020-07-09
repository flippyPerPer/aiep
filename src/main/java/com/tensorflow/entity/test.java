package com.tensorflow.entity;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		int i=0;
		List<Class> list = new ArrayList<Class>(); 
		while (i<5) {
			//鑻ユ壘鍒帮紝鍒欏悜list涓坊鍔犱竴鏉℃暟鎹��
			Class class1 = new Class();
			class1.setClassName("鎴愬姛浜�"+i+"娆�");
			list.add(class1);
			i++;
		}
		for(i=0;i<5;i++) {
			System.out.println(list.get(i));			
		}
	}

}
