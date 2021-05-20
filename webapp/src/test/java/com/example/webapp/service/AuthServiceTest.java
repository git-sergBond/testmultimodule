package com.example.webapp.service;


import api.dto.AuthPasswordDto;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


class AuthServiceTest {

    @InjectMocks
    AuthService authService;

    /**
     * TODO method @Before / @BeforeClass not work
     */
    @Before
    public void setUp() {
        System.out.println("BEFORE");
    }

    /**
     * IF login == password
     * EXPECTED: true
     */
    @Test
    public void loginTrue() {
        MockitoAnnotations.initMocks(this);

        AuthPasswordDto authPasswordDto = new AuthPasswordDto();
        authPasswordDto.setPassword("1");
        authPasswordDto.setLogin("1");
        Assertions.assertTrue(authService.login(authPasswordDto));
    }

    /**
     * IF login != password
     * EXPECTED: false
     */
    @Test
    public void loginFalse() {
        MockitoAnnotations.initMocks(this);

        AuthPasswordDto authPasswordDto = new AuthPasswordDto();
        authPasswordDto.setPassword("1");
        authPasswordDto.setLogin("111");
        Assertions.assertFalse(authService.login(authPasswordDto));
    }

    /**
     * IF authPasswordDto == null
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError1() {
        MockitoAnnotations.initMocks(this);
        try {
            boolean res = authService.login(null);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF login == null AND password == null
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError2() {
        MockitoAnnotations.initMocks(this);
        try {
            boolean res = authService.login(new AuthPasswordDto());
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF login == null
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError3() {
        MockitoAnnotations.initMocks(this);
        try {
            AuthPasswordDto authPasswordDto = new AuthPasswordDto();
            authPasswordDto.setPassword("1");
            //authPasswordDto.setLogin("111");

            boolean res = authService.login(authPasswordDto);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF password == null
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError4() {
        MockitoAnnotations.initMocks(this);
        try {
            AuthPasswordDto authPasswordDto = new AuthPasswordDto();
            //authPasswordDto.setPassword("1");
            authPasswordDto.setLogin("111");

            boolean res = authService.login(authPasswordDto);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF login is Empty AND passwod is Empty
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError5() {
        MockitoAnnotations.initMocks(this);
        try {
            AuthPasswordDto authPasswordDto = new AuthPasswordDto();
            authPasswordDto.setPassword("");
            authPasswordDto.setLogin("");

            boolean res = authService.login(authPasswordDto);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF login is Empty
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError6() {
        MockitoAnnotations.initMocks(this);
        try {
            AuthPasswordDto authPasswordDto = new AuthPasswordDto();
            authPasswordDto.setPassword("1");
            authPasswordDto.setLogin("");

            boolean res = authService.login(authPasswordDto);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }

    /**
     * IF password is Empty
     * EXPECTED: IllegalArgumentException
     */
    @Test
    public void loginError7() {
        MockitoAnnotations.initMocks(this);
        try {
            AuthPasswordDto authPasswordDto = new AuthPasswordDto();
            authPasswordDto.setPassword("");
            authPasswordDto.setLogin("111");

            boolean res = authService.login(authPasswordDto);
            Assertions.fail("IllegalArgumentException was expected but returned: " + res);
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (Exception e) {
            Assertions.fail("IllegalArgumentException was expected but ", e);
        }
    }
}