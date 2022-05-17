package com.cts.boots3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
	
	@Value("${cloud.aws.credentials.access-key}")
		private String accesskey;
	
	@Value("${cloud.aws.credentials.access-key}")
	private String secretKey;
	
	@Value("${cloud.aws.credentials.access-key}")
	private String region;
	
	@Bean
	public AmazonS3 s3Client() {
		
		AWSCredentials credentials = new BasicAwsCredentials(accessKey, secretKey);
		return AmazonS3ClientBuilder.
				standard().
				withCredentials(new AWSStaticCredentialsProvider(credentials)).
				withRegion(region).
				build();
	}
}
