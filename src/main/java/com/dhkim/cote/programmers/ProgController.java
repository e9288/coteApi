package com.dhkim.cote.programmers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/programmers")
public class ProgController {
	
	private static final Log logger = LogFactory.getLog (ProgController.class);
	
	@Autowired
	ProgSolution p_solution;
	
//	@GetMapping(value = "/product.json", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@GetMapping(value = "/test")
	public JSONObject productForm(String liveSeqNo) {
		JSONObject result = null;
		try {
			result = new JSONObject();
			result.put("test", "T-E-S-T");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value = "/hash_1")
	@Operation(summary = "programmers hash_1 완주하지 못한 선수", description = "My Description")
	public JSONObject hash_1(@RequestBody HashVo hash_vo) {
		JSONObject result = null;
		try {
			logger.info("RequestBody : " + hash_vo.toString());
			String answer = this.p_solution.hash_1_solution(hash_vo.getParticipant(), hash_vo.getCompletion());
			
			result = new JSONObject();
			result.put("answer", answer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value = "/hash_2")
	public JSONObject hash_2(@RequestBody HashVo hash_vo) {
		JSONObject result = null;
		try {
			logger.info("RequestBody : " + hash_vo.toString());
			boolean answer = this.p_solution.hash_2_solution(hash_vo.getPhone_book());
			
			result = new JSONObject();
			result.put("answer", answer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value = "/hash_3")
	public JSONObject hash_3(@RequestBody HashVo hash_vo) {
		JSONObject result = null;
		try {
			logger.info("RequestBody : " + hash_vo.toString());
			boolean answer = this.p_solution.hash_2_solution(hash_vo.getPhone_book());
			
			result = new JSONObject();
			result.put("answer", answer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
