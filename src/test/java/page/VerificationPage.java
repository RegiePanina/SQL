package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public void verificationPageVisibility() {
        codeField.shouldBe(Condition.visible);
    }
    public DashboardPage validVerify(String verificationCode) {
        verifyButtonClick(verificationCode);
        return new DashboardPage();
    }

    public void  errorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public void verifyButtonClick(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
