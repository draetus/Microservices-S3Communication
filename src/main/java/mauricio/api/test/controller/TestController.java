package mauricio.api.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mauricio.api.test.model.dto.request.TestRequestDTO;

@RequestMapping("/test")
public interface TestController {
	
	@PostMapping
	public ResponseEntity<?> sendTestImage(@RequestBody TestRequestDTO requestDTO);

}
