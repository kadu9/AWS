package com.automation.aws;


public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String email = " eysld@astest.com";
		String accessKey = "";
		// AWS secret key
		String secretKey = "";
		// Key Name
		String keyName="";
		String publicKeyMaterial="";

		AWSSingupFormAutomation singupFormAutomation = new AWSSingupFormAutomation();
		singupFormAutomation.setUp();
		singupFormAutomation.testAwsjunit4Webdriver(email);
		singupFormAutomation.tearDown();

		System.out.println("Finished with Sign up form Automation ..");
		// Update Account Password Policy and create Account alias
		UpdatePasswordPolicyAndCreateAlias accountPasswordPolicy = new UpdatePasswordPolicyAndCreateAlias();
		accountPasswordPolicy.updatePasswordPolicyAndCreateAlias(accessKey,
				secretKey);
		
		// Import adsk-eis-infra-nat key
		ImportKeyPairFromAWS importKeyPairFromAWS =  new  ImportKeyPairFromAWS();
		importKeyPairFromAWS.ImportKeyPairFromAWS(accessKey, secretKey, keyName, publicKeyMaterial);

	}

}
