package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaLoginPageObject extends PageObjectBase {

    private MobileElement botaoCadastro;
    private MobileElement botaoLogin;
    private MobileElement inputUsuario;
    private MobileElement inputSenha;
    private MobileElement mensagemError;
    private final By botaoCadastroId;
    private final By botaoLoginId;
    private final By inputUsuarioId;
    private final By inputSenhaId;
    private  final By erroId;



    public TelaLoginPageObject(AppiumDriver driver){
        super(driver);
        botaoCadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoLoginId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        inputUsuarioId = By.id("br.com.alura.aluraesporte:id/input_usuario");
        inputSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        erroId = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
    }
    @Override
    public void BuscarElementos() {
        inputUsuario = (MobileElement) driver.findElement(inputUsuarioId);
        inputSenha = (MobileElement) driver.findElement(inputSenhaId);
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroId);
        botaoLogin = (MobileElement) driver.findElement(botaoLoginId);
    }

    public void clicaBotaoCadastro() {
        botaoCadastro.click();
    }

    public void realizaLogin(String usuario, String senha){
        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(inputUsuarioId));

        inputUsuario.setValue(usuario);
        inputSenha.setValue(senha);
        botaoLogin.click();
    }

    public String msgErro(){
        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        mensagemError = (MobileElement) driver.findElement(erroId);
        return mensagemError.getText();
    }
}
