package co.com.sofka.certification.stepDefinitions;

import co.com.sofka.certification.models.BookData;
import co.com.sofka.certification.models.Bookingdates;
import co.com.sofka.certification.tasks.GenerateToken;
import co.com.sofka.certification.tasks.UpdateBook;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static co.com.sofka.certification.utils.constants.Constants.BASE_URL_API;
import static co.com.sofka.certification.utils.constants.Constants.DIDIER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateBooksStepDefinition {

    @Before
    public void setup(){
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(BASE_URL_API)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @DataTableType
    public BookData convert(Map<String, String> obj){
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin(obj.get("Checkin") == null ? "" : obj.get("Checkin"));
        bookingdates.setCheckout(obj.get("Checkout") == null ? "" : obj.get("Checkout"));

        BookData resp = new BookData();
        resp.setIdBook(obj.get("IdBook") == null ? "" : obj.get("IdBook"));
        resp.setFirstname(obj.get("Firstname") == null ? "" : obj.get("Firstname"));
        resp.setLastname(obj.get("Lastname") == null ? "" : obj.get("Lastname"));
        resp.setTotalprice(Double.valueOf(obj.get("Totalprice") == null ? "" : obj.get("Totalprice")));
        resp.setDepositpaid(Boolean.valueOf(obj.get("Depositpaid") == null ? "" : obj.get("IdBook")));
        resp.setBookingdates(bookingdates);
        resp.setAdditionalneeds(obj.get("AdditionalNeeds") == null ? "" : obj.get("AdditionalNeeds"));

        return resp;
    }

    @Given("I generate access token")
    public void iGenerateAccessToken() {
        theActorCalled(DIDIER).wasAbleTo(
                GenerateToken.data()
        );
    }
    @When("I update book with the information")
    public void iUpdateBookWithTheInformation(BookData data) {
        theActorInTheSpotlight().attemptsTo(
                UpdateBook.with(data)
        );
    }
    @Then("The service display the updated information")
    public void theServiceDisplayTheUpdatedInformation(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
