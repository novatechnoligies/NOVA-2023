package com.awsS3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSS3Config {

	
	@Value("AKIA5VELUWCBBOPT63VU")
    private String awsId;

    @Value("cpfZh4xyWQ+UjRdEhgmlmAY/RI8bI+0Lbn05eoJL")
    private String awsKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public AmazonS3 s3Client() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsId, awsKey);
        AmazonS3 amazonS3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        return amazonS3Client;
    }
}

