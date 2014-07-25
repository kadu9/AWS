package com.automation.aws;


import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.amazonaws.services.autoscaling.model.LimitExceededException;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClient;
import com.amazonaws.services.identitymanagement.model.*;

public class UpdatePasswordPolicyAndCreateAlias {

	public void updatePasswordPolicyAndCreateAlias(String accessKey,
			String secretKey) {

		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,
				secretKey);

		AmazonIdentityManagementClient identityManagementClient = new AmazonIdentityManagementClient(
				awsCredentials);

		UpdateAccountPasswordPolicyRequest accountPasswordPolicyRequest = new UpdateAccountPasswordPolicyRequest();

		Integer minimumPasswordLength = 8;
		Boolean allowUsersToChangePassword = true;

		accountPasswordPolicyRequest
				.setAllowUsersToChangePassword(allowUsersToChangePassword);
		accountPasswordPolicyRequest
				.setMinimumPasswordLength(minimumPasswordLength);

		Boolean requireLowercaseCharacters = true;
		accountPasswordPolicyRequest
				.setRequireLowercaseCharacters(requireLowercaseCharacters);
		Boolean requireNumbers = true;
		accountPasswordPolicyRequest.setRequireNumbers(requireNumbers);
		Boolean requireSymbols = true;
		accountPasswordPolicyRequest.setRequireSymbols(requireSymbols);
		Boolean requireUppercaseCharacters = true;
		accountPasswordPolicyRequest
				.setRequireUppercaseCharacters(requireUppercaseCharacters);
		// accountPasswordPolicyRequest.setHardExpiry(30);

		Logger logger = Logger.getLogger("MyLog");
		FileHandler fileHandler;

		try {
			// Update the account password policy
			identityManagementClient
					.updateAccountPasswordPolicy(accountPasswordPolicyRequest);
			java.util.Date date = new java.util.Date();
			fileHandler = new FileHandler("C:/AWS_Automation_Logs/AWSLogfile"
					+ date.getTime() + ".log");
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.info("Updated Account Password Policy successfully.");

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MalformedPolicyDocumentException e) {
			// TODO: handle exception
			logger.info("Error updating Password Policy.Account Password policy is not updated");
		} catch (NoSuchEntityException e) {
			// TODO: handle exception
			logger.info("Error updating Password Policy.Account Password policy is not updated");
		} catch (LimitExceededException e) {
			// TODO: handle exception
			logger.info("Error updating Password Policy.Account Password policy is not updated");
		} catch (AmazonClientException e) {
			// TODO: handle exception
			logger.info("Error updating Password Policy.Account Password policy is not updated");
		}

		/*
		 * Create Account Alias for AWS Account
		 */
		try {
			CreateAccountAliasRequest accountAliasRequest = new CreateAccountAliasRequest();
			accountAliasRequest.setRequestCredentials(awsCredentials);
			String accountAlias = "mayurkadu";

			accountAliasRequest.setAccountAlias(accountAlias);
			identityManagementClient.createAccountAlias(accountAliasRequest);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error Creating AWS Account Alias");
		}

	}
}
