package com.tec.dto;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.tec.register.RegisterEntity;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject results = new JSONObject();
		JSONArray arra = new JSONArray();
		List<JSONObject> data = new ArrayList<>();
		for (int i =0;i<4;i++) {
			JSONObject aas = new JSONObject();
			aas.put("Obj", i);
			data.add(aas);
		}
		results.put("results", data);
		System.out.println(results);
	}

}
