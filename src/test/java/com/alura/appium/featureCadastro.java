package com.alura.appium;

;
import com.alura.appium.pageObjects.TelaCadastroPageObject;
import com.alura.appium.pageObjects.TelaLoginPageObject;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;

public class featureCadastro {
    Faker faker = new Faker();

    @Test
    public void nao_consigo_cadastrar_usuario_com_senha_que_nao_conferem() {

        String usuario = faker.name().fullName();
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        TelaLoginPageObject telalogin = new TelaLoginPageObject(driver);
        telalogin.BuscarElementos();
        telalogin.clicaBotaoCadastro();

        TelaCadastroPageObject telaCadastro = new TelaCadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(usuario, "123", "123Abc");

        Assert.assertEquals("Senhas não conferem", telaCadastro.msgErro());
        driver.navigate().back();
    }

    @Test
    public void cadastro_de_usuario_com_sucesso() throws MalformedURLException, NoSuchElementException {
        String usuario = faker.name().fullName();
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        TelaLoginPageObject telalogin = new TelaLoginPageObject(driver);
        telalogin.BuscarElementos();
        telalogin.clicaBotaoCadastro();

        TelaCadastroPageObject telaCadastro = new TelaCadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(usuario, "123", "123");

        telalogin.BuscarElementos();
    }

    @Test
    public void cadastro_de_usuario_duplicado() throws MalformedURLException, NoSuchElementException {
        String usuario = faker.name().fullName();
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        TelaLoginPageObject telalogin = new TelaLoginPageObject(driver);
        telalogin.BuscarElementos();
        telalogin.clicaBotaoCadastro();

        TelaCadastroPageObject telaCadastro = new TelaCadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(usuario, "123", "123");

        telalogin.BuscarElementos();
        telalogin.clicaBotaoCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(usuario, "123", "123");
        Assert.assertEquals("Usuario já Cadastrado", telaCadastro.msgErro());
        driver.navigate().back();
    }
}
