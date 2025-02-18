package mauricio.external;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import mauricio.component.log.ErrorLogger;
import mauricio.environment.S3Environment;
import mauricio.exception.internal.AwsS3FailedException;

@Service
public class S3CommunicationService {
	
	@Autowired
	private S3Environment s3Environment;
	
	@Autowired
	private AmazonS3 s3Client;
	
	public void uploadObject(String prefix, String fileKey, InputStream file) {
		fileKey = s3Environment.filePrefix + prefix + fileKey;
        try {
        	s3Client.putObject(s3Environment.bucketName, fileKey, file, new ObjectMetadata());
        } catch (AmazonServiceException e) {
        	ErrorLogger.log(e);
            throw new AwsS3FailedException();
        }
    }
	
	public ListObjectsV2Result findAll(String filePrefix) {
        try {
        	return s3Client.listObjectsV2(s3Environment.bucketName, s3Environment.filePrefix + filePrefix);
        } catch (AmazonServiceException e) {
        	ErrorLogger.log(e);
        	throw new AwsS3FailedException();
        }
    }
	
	public InputStreamResource downloadObject(String filePrefix, String fileKey) {
        try {
        	S3Object o = s3Client.getObject(s3Environment.bucketName, filePrefix + fileKey);
            S3ObjectInputStream s3is = o.getObjectContent();
            
            byte[] bytes = IOUtils.toByteArray(s3is);
            return new InputStreamResource(new ByteArrayInputStream(bytes));
        } catch (AmazonServiceException e) {
        	ErrorLogger.log(e);
        	throw new AwsS3FailedException();
        } catch (IOException e) {
        	ErrorLogger.log(e);
        	throw new AwsS3FailedException();
		}
        
    }
	
	public void deleteObject(String fileKey) {
		try {
			s3Client.deleteObject(new DeleteObjectRequest(s3Environment.bucketName, fileKey));
        } catch (AmazonServiceException e) {
        	ErrorLogger.log(e);
        	throw new AwsS3FailedException();
        }
	}

}
