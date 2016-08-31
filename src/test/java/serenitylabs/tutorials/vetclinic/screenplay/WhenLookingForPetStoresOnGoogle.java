package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.vetclinic.screenplay.pages.GoogleSearchPage;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenLookingForPetStoresOnGoogle {

    GoogleSearchPage googleSearchPage;

    @Managed(driver="chrome")
    WebDriver petesBrowser;

    @Test
    public void should_find_local_pet_stores() {

        Actor pete = Actor.named("Pete");

        // GIVEN
        pete.can(BrowseTheWeb.with(petesBrowser));

        // WHEN
        pete.attemptsTo(
                Open.browserOn().the(googleSearchPage),
                Enter.theValue("pet stores")
                     .into(GoogleSearchPage.SEARCH_FIELD)
        );

        // THEN
        pete.should(
                eventually(seeThat(TheWebPage.title(),
                                   containsString("pet stores")))
        );
    }
}
