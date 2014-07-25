package com.aws.automation;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AWSSingupFormAutomation singupFormAutomation = new AWSSingupFormAutomation();
		singupFormAutomation.setUp();
		String email = " eyssolld@awstest.com";
		String accessKey = "AKIAJVEJ77QXCF3KFPYQ";
		// AWS secret key
		String secretKey = "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";

		singupFormAutomation.testAwsjunit4Webdriver(email);

		singupFormAutomation.tearDown();

		System.out.println("Finished with Sign up form Automation ..");

		UpdateAccountPasswordPolicy accountPasswordPolicy = new UpdateAccountPasswordPolicy();
		accountPasswordPolicy.updatePasswordPolicyAndCreateAlias(accessKey,
				secretKey);

	}

}
