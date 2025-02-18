package mauricio.component.log;

import static mauricio.component.utils.ObjectUtils.isNotNull;

import java.time.LocalDateTime;

public class ErrorLogger {
	
	public static void log(Exception ex) {
		System.err.println(LocalDateTime.now() + " Message: " + ex.getMessage());
		System.err.println(LocalDateTime.now() + " StackTrace: ");
		ex.printStackTrace();
		System.err.println(LocalDateTime.now() + " Cause: " + (isNotNull(ex.getCause()) ? ex.getCause().toString() : "Cause not found"));
	}

}
