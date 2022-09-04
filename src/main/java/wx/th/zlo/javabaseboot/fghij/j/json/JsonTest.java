package wx.th.zlo.javabaseboot.fghij.j.json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/*
 * JSON对象 用Map<key、value>存储JSON数据。
 * API:
 * 		1.JSON.parseObject(str,user.class)
 * 		2.JSON.toJSONString(user)
 * 		3.JSON.parseArray(str,user.calss)
 * 		
 * 
 * 
 * */


public class JsonTest {
	public static void main(String[] args) {
		String jsonStr = "{\"a\":\"5614\",\"b\":\"11\",\"c\":\"205\",\"d\":\"5\",\"e\":\"0\"}";
		//将jsonstr 转化成  jsonObject，
		JSONObject parseObject = JSON.parseObject(jsonStr);
		Zm zm2 = parseObject.toJavaObject(Zm.class);
		String zm3 = parseObject.getObject("a", String.class);
		//将jsonstr 转化成  jsonObject，再转化成 java对象
		Zm zm = JSON.parseObject(jsonStr,Zm.class);
		
		//将jsonstr 转化成 jsonArr 
		String jsonArrStr = "[{\"a\":\"5614\",\"b\":\"11\",\"c\":\"205\",\"d\":\"5\",\"e\":\"0\"},{\"a\":\"5614\",\"b\":\"11\",\"c\":\"205\",\"d\":\"5\",\"e\":\"0\"}]";
		JSONArray jsonArray = JSON.parseArray(jsonArrStr);
		//将jsonArr 转化成 list
		List<Zm> javaList = jsonArray.toJavaList(Zm.class);
		
		String jsonString = JSON.toJSONString(javaList);
		
		List<Zm> parseArray = JSON.parseArray(jsonArrStr,Zm.class);
		System.out.println(jsonString);
		
		return;
	}
}