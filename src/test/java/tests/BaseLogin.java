package tests;

public class BaseLogin extends BaseTest {

    public void login() {
        mainSteps
                .openLoginPage()
                .loginWithValidCreds();
    }

}
