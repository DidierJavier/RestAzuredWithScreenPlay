package co.com.sofka.certification.interactions;

import co.com.sofka.certification.models.BookData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.sofka.certification.utils.HeaderParamsApi.CONTENT_TYPE_JSON;
import static co.com.sofka.certification.utils.HeaderParamsApi.COOKIES;
import static co.com.sofka.certification.utils.constants.Constants.*;
import static co.com.sofka.certification.utils.constants.GeneratyBody.bodyUpdateBook;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestUpdateBook implements Interaction {

    private String idBook;

    private BookData data;

    public RequestUpdateBook(BookData data) {
        this.idBook = data.getIdBook();
        this.data = data;
    }

    public static Performable with(BookData data){
        return instrumented(RequestUpdateBook.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall(TOKEN_RESPONSE).toString();
        actor.attemptsTo(
                Put.to(String.format(URL_UPDATE_BOOK, idBook))
                        .with(
                                requestSpecification -> requestSpecification
                                        .header(CONTENT_TYPE_JSON.getKey(), CONTENT_TYPE_JSON.getValue())
                                        .header(COOKIES.getKey(), COOKIES.getValue() + "" + token)
                                        .body(bodyUpdateBook(data))
                                        .log().all()
                        )
        );
    }

}
