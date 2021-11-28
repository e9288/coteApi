package com.iandna.gateway.programmers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/programmers")
public class ProgController {
	
//	@GetMapping(value = "/product.json", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@GetMapping(value = "/test")
	public JSONObject productForm(String liveSeqNo) {
		JSONObject result = null;
		try {
			result = new JSONObject();
			result.put("test", "장정미사랑행 복권맞으면 혼자 가지기 없어");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
