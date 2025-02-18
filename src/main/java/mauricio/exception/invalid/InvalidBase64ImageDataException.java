package mauricio.exception.invalid;

import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidBase64ImageDataException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public InvalidBase64ImageDataException() {
		super(HttpStatus.BAD_REQUEST, ResourceBundle.getBundle("messages/exception_messages").getString("invalid.base64imagedata"));
	}

}
