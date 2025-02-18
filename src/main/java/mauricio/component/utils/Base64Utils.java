package mauricio.component.utils;

import static mauricio.component.utils.ObjectUtils.not;
import static org.springframework.util.StringUtils.hasText;

import java.util.Base64;

import mauricio.exception.invalid.InvalidBase64ImageDataException;

public class Base64Utils {
	
	public static byte[] decode(String base64String) {
		if (not(hasText(base64String))) {
			return null;
		}
		
		try {	
			return Base64.getDecoder().decode(base64String);
		} catch (IllegalArgumentException e) {
			throw new InvalidBase64ImageDataException();
		}
		
	}
	
	public static String encode(byte[] image) {
		if (image == null || image.length < 1) {
			return null;
		}
		
		try {
			return Base64.getEncoder().encodeToString(image);
		} catch (IllegalArgumentException e) {
			throw new InvalidBase64ImageDataException();
		}
		
	}

}
