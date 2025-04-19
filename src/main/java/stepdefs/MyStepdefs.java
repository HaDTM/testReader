package stepdefs;

import core.AppiumBase;
import functions.FaceMOC;
import functions.FaceMocAuto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class MyStepdefs {
    @Given("I open app eIDDemo")
    public void iOpenAppEIDDemo() {
        try {
            AppiumBase.createDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @When("Capture and MOC")
    public void captureAndMOC() {
        FaceMocAuto.FaceMoc1000Times();
    }

    @When("I click button Capture")
    public void iClickButtonCapture() {
        FaceMOC.CaptureButtonClick();
    }


    @Then("The Card Detail is visible")
    public void theCardDetailIsVisible() {
        FaceMOC.VerifyCardDetail();
    }


    @And("I click button Finish")
    public void iClickButtonFinish() {
        FaceMOC.FinishButtonClick();
    }
}
