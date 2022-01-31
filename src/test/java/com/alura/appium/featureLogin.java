package com.alura.appium;

import com.alura.appium.pageObjects.HomePageObject;
import com.alura.appium.pageObjects.TelaCadastroPageObject;
import com.alura.appium.pageObjects.TelaLoginPageObject;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

public class featureLogin {
    Faker faker = new Faker();

    @Test
    public void login_com_sucesso(){
        String usuario = faker.name().fullName();
        String senha = "123456";
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        TelaLoginPageObject telalogin = new TelaLoginPageObject(driver);
        telalogin.BuscarElementos();
        telalogin.clicaBotaoCadastro();

        TelaCadastroPageObject telaCadastro = new TelaCadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(usuario, senha, senha);

        telalogin.BuscarElementos();
        telalogin.realizaLogin(usuario, senha);

        HomePageObject home = new HomePageObject(driver);
        home.BuscarElementos();
        home.clicaBotaoSair();
    }

    @Test
    public void login_sem_sucesso(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        TelaLoginPageObject telalogin = new TelaLoginPageObject(driver);

        telalogin.BuscarElementos();
        telalogin.realizaLogin("usuarioErrado", "SenhaErrada");
        Assert.assertEquals("Usuário ou senha inválidos", telalogin.msgErro());

    }
}
