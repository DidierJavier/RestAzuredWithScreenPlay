package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.RequestUpdateBook;
import co.com.sofka.certification.models.BookData;
import co.com.sofka.certification.models.BookResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateBook implements Task {

    private BookData data;

    public UpdateBook(BookData data){
        this.data = data;
    }

    public static Performable with(BookData data){
        return instrumented(UpdateBook.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RequestUpdateBook.with(data)
        );
    }
}
