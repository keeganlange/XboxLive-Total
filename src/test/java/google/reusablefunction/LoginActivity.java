package google.reusablefunction;
import java.util.Properties;

import org.testng.Assert;

import google.basepages.GoogleHomePage;
import google.basepages.GoogleSignInPage;
import util.SystemUtil;

//this is an reusable function, which methods would take actions on several pages
public class LoginActivity {
	//sign in default user
	//first, go to google homepage
	//then sign in
	//at last, it would direct to google homepage again 
	//so it reutrns a google homepage page object
	public static GoogleHomePage signInDefaultUser() throws Exception {
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_google.properties");
		String email = PROPERTIES_RESOURCES.getProperty("login.email");
		String pwd = PROPERTIES_RESOURCES.getProperty("login.password");

		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.open();
		GoogleSignInPage googleSignInPage = googleHomePage.gotoSignPage();
		return googleSignInPage.signIn(email, pwd);
	}

}
