package fitness_api.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;


public class JsonUtils {
	
//	public String convertListToJsonString(List<?> list) {
//		JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
//		String jsonString = null;
//		try {
//			jsonString = js.serialize(list);
//		} catch (SerializeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jsonString;
//		
//	}
	
	public String convertObjectToJsonString(Object obj) {
		JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
		String jsonString = null;
		try {
			jsonString = js.serialize(obj);
		} catch (SerializeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}
	
	
	public static void main(String[] args) throws SerializeException {
		List<Integer> list = Arrays.asList(1,2,3,4);
//		JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
//		System.out.println(js.serialize(list));
//		System.out.println(new JsonUtils().convertListToJsonString(list));
	}
}
