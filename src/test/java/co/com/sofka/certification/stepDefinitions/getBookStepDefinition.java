package co.com.sofka.certification.stepDefinitions;

import co.com.sofka.certification.models.BookResponse;
import co.com.sofka.certification.models.Bookingdates;
import co.com.sofka.certification.questions.BookDataResponse;
import co.com.sofka.certification.tasks.ConsultBook;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static co.com.sofka.certification.utils.Constants.BASE_URL_API;
import static co.com.sofka.certification.utils.FieldsResponse.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class getBookStepDefinition {

    private static final String DIDIER = "Didier";

    @Before
    public void setup(){
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(BASE_URL_API)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @DataTableType
    public BookResponse convert(Map<String, String> obj){
        BookResponse resp = new BookResponse();
        Bookingdates bookingdates = new Bookingdates();

        bookingdates.setCheckout(obj.get("Checkout") == null ? "" : obj.get("Checkout"));
        bookingdates.setCheckin(obj.get("Checkin") == null ? "" : obj.get("Checkin"));
        resp.setFirstname(obj.get("Firstname") == null ? "" : obj.get("Firstname"));
        resp.setLastname(obj.get("Lastname") == null ? "" : obj.get("Lastname"));
        resp.setDepositpaid(obj.get("Depositpaid") == null ? false :Boolean.parseBoolean(obj.get("Depositpaid")));
        resp.setTotalprice(obj.get("Totalprice") == null ? 0.0 :Double.parseDouble(obj.get("Totalprice")));
        resp.setBookingdates(bookingdates);
        resp.setAdditionalneeds(obj.get("AdditionalNeeds") == null ? "" : obj.get("AdditionalNeeds"));

        return resp;

    }

    @When("I request book information with id {string}")
    public void iRequestBookInformationWithId(String bookId) {
        theActorCalled(DIDIER).attemptsTo(
                ConsultBook.with(bookId)
        );
    }
    @Then("The service must show")
    public void theServiceMustShow(BookResponse data) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(BookDataResponse.extract(FIRST_NAME)).isEqualTo(data.getFirstname()),
                Ensure.that(BookDataResponse.extract(LAST_NAME)).isEqualTo(data.getLastname()),
                Ensure.that(BookDataResponse.extract(TOTAL_PRICE)).isEqualTo(Double.toString(data.getTotalprice())),
                Ensure.that(BookDataResponse.extract(DEPOSIT_PAID)).isEqualTo(Boolean.toString(data.getDepositpaid())),
                Ensure.that(BookDataResponse.extract(CHECKIN)).isEqualTo(data.getBookingdates().getCheckin()),
                Ensure.that(BookDataResponse.extract(CHECKOUT)).isEqualTo(data.getBookingdates().getCheckout())
        );
    }

}
