package apiTestClasses;

import java.util.HashMap;
import java.util.Map;

public class ComplexPayloadsUsingMapList {

	public static void main(String[] args) {

		Map<String, Object> postsValue = new HashMap<String, Object>();
		postsValue.put("id", 5);
		postsValue.put("title", "json-server");
		postsValue.put("author", "typicode");

		Map<String, Object> infoValue = new HashMap<String, Object>();
		infoValue.put("email", "info@selenium.com");
		infoValue.put("phone", "7676223061");
		infoValue.put("address", "LKVD College road,Tajpur Samastipur, Bihar");
		infoValue.put("pincode", "848130");

		postsValue.putAll(infoValue);

		System.out.println(postsValue);
	}

}
