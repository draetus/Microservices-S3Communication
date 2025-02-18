package mauricio.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S3Environment {
	
	@Value("${aws.s3.bucket.name}")
	public String bucketName;
	
	@Value("${aws.s3.bucket.prefix}")
	public String filePrefix;
	
	@Value("${aws.s3.bucket.user}")
	public String bucketUser;
	
	@Value("${aws.s3.bucket.region}")
	public String bucketRegion;
	
	@Value("${aws.acess.key_id}")
	public String accessKeyId;
	
	@Value("${aws.secret_access_key}")
	public String secretAccessKey;

}
