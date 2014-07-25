package com.aws.automation;
import com.google.common.base.Function;
public class AWSAutomationDriverClass {
	private String email;

	public AWSAutomationDriverClass(String email) {
		super();
		this.email = email;
	}

	public void automateAWS() throws Exception {

		// AWS access key
		String accessKey = "AKIAJVEJ77QXCF3KFPYQ";
		// AWS secret key
		String secretKey = "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";

		AWSSingupFormAutomation singupFormAutomation = new AWSSingupFormAutomation();
		singupFormAutomation.setUp();
		singupFormAutomation.automateAWSUsingJunit(this.email);
		singupFormAutomation.tearDown();

		System.out.println("Finished with Sign up form Automation ..");

		// Update Account Password Policy and Create Account alias
		UpdateAccountPasswordPolicy accountPasswordPolicy = new UpdateAccountPasswordPolicy();
		accountPasswordPolicy.updatePasswordPolicyAndCreateAlias(accessKey,
				secretKey);

	}

}