package co.com.sofka.certification.stepDefinitions;

import co.com.sofka.certification.models.BookData;
import co.com.sofka.certification.models.Bookingdates;
import co.com.sofka.certification.questions.BookDataResponse;
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
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static co.com.sofka.certification.utils.FieldsResponse.*;
import static co.com.sofka.certification.utils.constants.Constants.*;
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
        resp.setDepositpaid(Boolean.valueOf(obj.get("Depositpaid") == null ? "" : obj.get("Depositpaid")));
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
    public void theServiceDisplayTheUpdatedInformation(BookData data) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(BookDataResponse.extract(FIRST_NAME).from(RESPONSE_UPDATE_BOOK)).isEqualTo(data.getFirstname()),
                Ensure.that(BookDataResponse.extract(LAST_NAME).from(RESPONSE_UPDATE_BOOK)).isEqualTo(data.getLastname()),
                Ensure.that(BookDataResponse.extract(TOTAL_PRICE).from(RESPONSE_UPDATE_BOOK)).isEqualTo(Double.toString(data.getTotalprice())),
                Ensure.that(BookDataResponse.extract(DEPOSIT_PAID).from(RESPONSE_UPDATE_BOOK)).isEqualTo(Boolean.toString(data.getDepositpaid())),
                Ensure.that(BookDataResponse.extract(CHECKIN).from(RESPONSE_UPDATE_BOOK)).isEqualTo(data.getBookingdates().getCheckin()),
                Ensure.that(BookDataResponse.extract(CHECKOUT).from(RESPONSE_UPDATE_BOOK)).isEqualTo(data.getBookingdates().getCheckout()),
                Ensure.that(BookDataResponse.extract(ADDITIONALNEEDS).from(RESPONSE_UPDATE_BOOK)).isEqualTo(data.getAdditionalneeds())
        );
    }
}
