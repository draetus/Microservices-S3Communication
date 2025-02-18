package mauricio.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import mauricio.environment.S3Environment;

@Configuration
public class S3Config {
	
	@Autowired
	private S3Environment s3Environment;
	
	@Bean
    AmazonS3 s3Client() {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(s3Environment.accessKeyId, s3Environment.secretAccessKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(s3Environment.bucketRegion))
				.withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
		return s3Client;
	}

}
