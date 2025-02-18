package mauricio.api.test.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mauricio.api.test.model.dto.request.TestRequestDTO;
import mauricio.component.utils.Base64Utils;
import mauricio.external.S3CommunicationService;

@RestController
public class TestControllerImpl implements TestController {
	
	@Autowired
	private S3CommunicationService s3CommunicationService;

	@Override
	public ResponseEntity<?> sendTestImage(TestRequestDTO requestDTO) {
		byte[] imageData = Base64Utils.decode(requestDTO.getBase64Image());
		InputStream is = new ByteArrayInputStream(imageData);
		s3CommunicationService.uploadObject("", "teste.png", is);
		return null;
	}

}
