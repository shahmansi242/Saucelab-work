package webexe;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    private By _registerLInk = By.linkText("Register");

    // verify that user click on register button
    public void clickOnRegisterButton() {
        clickOnElement(_registerLInk);
    }



}
