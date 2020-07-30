package com.twosome.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
		
	public static boolean isEmpty(String s) {
		if(s==null) return true;
		if(s.trim().equals("")) return true;
		return false;		
	}

	public static String getUriParam(String uri, String key) {
		if(uri==null) return null;
		if(key==null) return null;
		
		String params = null;
		String[] s1 = uri.split("\\?");		
		if(s1.length==2) {
			params = s1[1];
		} else {
			params = uri;			
		}
		
		String[] s2 = params.split("&");
		for(String s : s2) {
			String[] s3 = s.split("=");
			if(s3.length==2) {
				if(key.equals(s3[0])) {
					return s3[1];					
				}				
			}			
		}
		return null;
	}
	

	public static String makeJsonResult(Exception e) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		Map<String, String> map = new HashMap<>(); 
		map.put("result", "error"); 
		map.put("message", e.toString());
		try {
			jsonResult = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e1) {
			jsonResult = e1.toString();
			e1.printStackTrace();
		}
		return jsonResult;
	}
	
	public static String makeJsonResult(Object object) {
		return  makeJsonResult(object, 0);		
	}
	public static String makeJsonResult(Object object, int code) {
		return  makeJsonResult(object, code, null);				
	}
	public static String makeJsonResult(Object object, int code, String ret) {
		ObjectMapper mapper = new ObjectMapper();	
		String jsonResult = "";
		try {
			Map<String, String> map = new HashMap<>();
			if("false".equals(mapper.writeValueAsString(object))) {
				map.put("result", "false"); 				
			} else {
				map.put("result", "success");
			}
			map.put("message", mapper.writeValueAsString(object));
			if(code>0) map.put("code", ""+code);
			if(ret!=null) map.put("ret", ret);
			jsonResult = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			Map<String, String> map = new HashMap<>(); 
			map.put("result", "error"); 
			map.put("message", e.toString());
			if(code>0) map.put("code", ""+code);
			if(ret!=null) map.put("ret", ret);
			try {
				jsonResult = mapper.writeValueAsString(map);
			} catch (JsonProcessingException e1) {
				jsonResult = e1.toString();
				e1.printStackTrace();
			}
		}
		return jsonResult;
	}
	
	public static String makeJsonResult(boolean result) {
		return makeJsonResult(result, 0);		
	}
	public static String makeJsonResult(boolean result, int code) {
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("result", result ? "success" : Boolean.FALSE);
		if(code>0) rmap.put("code", new Integer(code));
		return makeJsonResult(rmap);		
	}

	public static String makeJsonResultWidthCount(boolean result, int count) {
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("result", result ? "success" : Boolean.FALSE);
		rmap.put("count", new Integer(count));
		return makeJsonResult(rmap);		
	}

	
	public static String makeJsonStr(Object object) {
		ObjectMapper mapper = new ObjectMapper();	
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}	
	
	
	public static String getMapValueString(Map<?, ?> map, String key) {
		return getMapValueString(map, key, null);
	}
	public static String getMapValueString(Map<?, ?> map, String key, String def) {
		if(map==null) return null;
		return map.get(key)!=null ? map.get(key).toString() : def;
	}

	public static int getMapValueInt(Map<?, ?> map, String key) {
		return getMapValueInt(map, key, -1);
	}
	public static int getMapValueInt(Map<?, ?> map, String key, int def) {
		if(map==null) return -1;
		return map.get(key)!=null ? Integer.valueOf(map.get(key).toString()) : def;
	}

	

	public static Map<String, Object> makeJsonMap(String jsonResp) {
		ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        try {
        	jsonMap = mapper.readValue(jsonResp, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
			return null;			
        }		
        return jsonMap;
	}

	
	
	
	public static String getResultMessageString(String jsonResp) {
		Map<String, String> mapResp = null;
		ObjectMapper mapper = new ObjectMapper();
        try {
        	mapResp = mapper.readValue(jsonResp, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
			return Utils.makeJsonResult(e);			
        }        
        if(mapResp!=null) {
        	String result = mapResp.get("result");
        	if("success".equals(result)) {
            	return mapResp.get("message");
        	}
        }
        return null;
	}
	
	public static Map<String, Object> getResultMessageMap(String jsonResp) {
		String message = getResultMessageString(jsonResp);
		if(message!=null) {
			return makeJsonMap(message);
		}
		return null;
	}
	
}
