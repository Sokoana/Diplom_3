package elements;



import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddInfoUser {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    private static final String DELETE_USER = "/api/auth/user";
    private static final String BIULD_USER = "/api/auth/register";
    private static final String AUTORIZATION_USER = "/api/auth/login";


    public static Response buildUser(Users user) {
        return given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .post(BASE_URL + BIULD_USER);
    }
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URL + DELETE_USER);
    }


    public static Response autorizationUser(Users user) {
        return given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .post(BASE_URL + AUTORIZATION_USER);
    }



}
