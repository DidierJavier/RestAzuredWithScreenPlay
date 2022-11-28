package co.com.sofka.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.sofka.certification.utils.constants.Constants.URL_GENERATE_TOKEN;
import static co.com.sofka.certification.utils.HeaderParamsApi.CONTENT_TYPE_JSON;
import static co.com.sofka.certification.utils.constants.GeneratyBody.bodyGetToken;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestToken implements Interaction {

    public static Performable token(){
        return instrumented(RequestToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(URL_GENERATE_TOKEN)
                        .with(
                                requestSpecification -> requestSpecification
                                        .headers(CONTENT_TYPE_JSON.getKey(), CONTENT_TYPE_JSON.getValue())
                                        .body(bodyGetToken())
                                        .log().all()
                        )
        );
    }
}
