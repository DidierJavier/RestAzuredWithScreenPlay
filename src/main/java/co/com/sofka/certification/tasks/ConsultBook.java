package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.RequestInformation;
import co.com.sofka.certification.interactions.SaveResponseInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.certification.utils.constants.Constants.RESPONSE_GET_BOOK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultBook implements Task {

    private String bookId;

    public ConsultBook(String bookId) {
        this.bookId = bookId;
    }

    public static Performable with(String bookId) {
        return instrumented(ConsultBook.class, bookId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RequestInformation.bookInformation(bookId),
                SaveResponseInformation.response(RESPONSE_GET_BOOK)
        );
    }
}
