package api_tests;

import dto.TokenDto;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseApi;
import utils.ILogin;

import java.io.IOException;

public class GetAllUserContactsApiTests implements BaseApi, ILogin {
    TokenDto tokenDto;

    @BeforeClass
    public void login(){
        tokenDto = loginGetToken();
    }

    @Test
    public void getAllUserContactsPositiveTest(){
        Request request = new Request.Builder()
                .url(BASE_URL+GET_ALL_CONTACTS)
                .get()
                .addHeader(AUTH, tokenDto.getToken())
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(response.code(), 200);
    }
}
