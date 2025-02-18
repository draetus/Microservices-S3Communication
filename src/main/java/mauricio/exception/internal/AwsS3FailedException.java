package mauricio.exception.internal;

import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AwsS3FailedException extends ResponseStatusException {

	private static final long serialVersionUID = 5151035069276114460L;
	
	public AwsS3FailedException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, ResourceBundle.getBundle("messages/exception_messages").getString("internal.s3"));
	}

}
