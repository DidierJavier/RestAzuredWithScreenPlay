package co.com.sofka.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.sofka.certification.utils.constants.Constants.URL_SEARCHBOOK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestInformation implements Interaction {

    private String bookId;

    public RequestInformation(String bookId) {
        this.bookId = bookId;
    }

    public static Performable bookInformation(String bookId) {
        return instrumented(RequestInformation.class, bookId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(String.format(URL_SEARCHBOOK,bookId))
                        .with(req -> req
                                .log().all())
        );
    }
}
