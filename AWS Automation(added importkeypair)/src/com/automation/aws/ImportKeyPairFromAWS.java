package com.automation.aws;

import com.amazonaws.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.policy.actions.EC2Actions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.ImportKeyPairResult;
import com.amazonaws.services.ec2.model.ImportKeyPairRequest;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.AmazonEC2;

public class ImportKeyPairFromAWS {
	public void ImportKeyPairFromAWS(String accessKey, String secretKey,
			String keyName, String publicKeyMaterial) {
		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,
				secretKey);

		ImportKeyPairRequest keyPairRequest = new ImportKeyPairRequest();

		keyPairRequest.setRequestCredentials(awsCredentials);
		keyPairRequest.setKeyName(keyName);
		keyPairRequest.setPublicKeyMaterial(publicKeyMaterial);
		AmazonEC2 ec2 = new AmazonEC2Client(awsCredentials);

		ImportKeyPairResult importKeyPairResult = ec2
				.importKeyPair(keyPairRequest);
		String awsKeyPair = importKeyPairResult.getKeyName();
		System.out.println(awsKeyPair);

	}

}
