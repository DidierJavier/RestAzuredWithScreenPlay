package co.com.sofka.certification.tasks;

import co.com.sofka.certification.interactions.RequestToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GenerateToken implements Task {

    public static Performable data(){
        return instrumented(GenerateToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RequestToken.token()
        );
    }
}
