package co.com.sofka.certification.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static co.com.sofka.certification.utils.constants.Constants.*;

@Getter
@AllArgsConstructor
public enum HeaderParamsApi {

    CONTENT_TYPE_JSON(CONTENT_TYPE, CONTENT_TYPE_VALUE),
    COOKIES(COOKIE, COOKIE_VALUE);

    private String key;

    private String value;
}
