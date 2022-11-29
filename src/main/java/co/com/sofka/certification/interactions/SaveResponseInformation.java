package co.com.sofka.certification.interactions;

import co.com.sofka.certification.models.BookResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static co.com.sofka.certification.utils.constants.Constants.RESPONSE_GET_BOOK;
import static co.com.sofka.certification.utils.constants.Constants.TOKEN_RESPONSE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveResponseInformation implements Interaction {

    private String vbleName;

    public SaveResponseInformation(String vbleName) {
        this.vbleName = vbleName;
    }

    public static Performable response(String vbleName) {
        return instrumented(SaveResponseInformation.class, vbleName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (vbleName){
            case RESPONSE_GET_BOOK:
                actor.remember(vbleName, SerenityRest.lastResponse().jsonPath().getObject("", BookResponse.class));
                break;
            case TOKEN_RESPONSE:
                actor.remember(vbleName, SerenityRest.lastResponse().jsonPath().get("token").toString());
                break;
        }
    }
}
