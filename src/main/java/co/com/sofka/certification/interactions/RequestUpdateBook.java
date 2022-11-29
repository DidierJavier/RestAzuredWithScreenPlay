package co.com.sofka.certification.interactions;

import co.com.sofka.certification.models.BookData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.sofka.certification.utils.constants.Constants.TOKEN_RESPONSE;
import static co.com.sofka.certification.utils.constants.Constants.URL_UPDATE_BOOK;
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
        );
    }

}
