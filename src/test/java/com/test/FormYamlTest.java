package com.test;

import com.configuration.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.moderntester.models.User;
import pl.moderntester.pages.basic.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormYamlTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(FormYamlTest.class);

    @Test
    public void shouldFillFormWithSuccess() {
        FormPage formPage = new FormPage(driver);
        User user = getEnvironmentConfig().getEnvironment().getUser();

        log.info("Start form test with yaml file");
        formPage.fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .chooseRandomSex()
                .fillAge(user.getAge())
                .chooseRandomExperience()
                .chooseProfession(FormPage.Profession.valueOf(user.getProfession()))
                .chooseRandomContinent()
                .selectCommands(user.getCommands())
                .sendFile(user.getFilePath())
                .signIn();
        assertThat("Wrong validator message", formPage.getValidatorMsg(), equalTo(getEnvironmentConfig()
                .getEnvironment()
                .getMessage()));
        log.info(passed, passedMessage);
    }
}