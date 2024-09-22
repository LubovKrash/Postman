package ru.netology.unit;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


class MainTest {

    @Test
    void main() {
        // Given - When - Then
// Предусловия
                given()
                .baseUri("https://postman-echo.com")
                .body("Hello World") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hello World"))
                        .header("Server", org.hamcrest.Matchers.equalTo("nginx/1.25.3"))
                        .contentType(ContentType.JSON)
        ;
    }
}