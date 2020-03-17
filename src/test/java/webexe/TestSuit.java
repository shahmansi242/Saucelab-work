package webexe;

import org.junit.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();





    @Test
    public void userShouldAbleToRegisterSuccessfully(){

        homePage.clickOnRegisterButton();
       // registrationPage.verifyUserOnRegisterPage();
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();

    }

}
