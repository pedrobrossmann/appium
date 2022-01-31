package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaCadastroPageObject extends PageObjectBase{

    private MobileElement inputNomeUsuario;
    private MobileElement inputSenha;
    private MobileElement inputConfirmarSenha;
    private MobileElement botaoFinalizarCadastro;
    private MobileElement mensagemError;
    private  final By erroId;
    private  final By inputNomeUsuarioId;
    private  final By inputSenhaId;
    private  final By inputConfirmarSenhaId;
    private  final By botaoFinalizarCadastroId;

    public TelaCadastroPageObject(AppiumDriver driver){
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        inputNomeUsuarioId = By.id("br.com.alura.aluraesporte:id/input_nome");
        inputSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        inputConfirmarSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoFinalizarCadastroId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        inputNomeUsuario = (MobileElement) driver.findElement(inputNomeUsuarioId);
        inputSenha = (MobileElement) driver.findElement(inputSenhaId);
        inputConfirmarSenha = (MobileElement) driver.findElement(inputConfirmarSenhaId);
        botaoFinalizarCadastro = (MobileElement) driver.findElement(botaoFinalizarCadastroId);
    }

    private void  PreencherFormulario(String usuario, String senha, String confirmarSenha){
        inputNomeUsuario.setValue(usuario);
        inputSenha.setValue(senha);
        inputConfirmarSenha.setValue(confirmarSenha);
    }

    public void Cadastrar(String usuario, String senha, String confirmarSenha) {
        PreencherFormulario(usuario, senha, confirmarSenha);
        botaoFinalizarCadastro.click();
    }

    public String msgErro(){
        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        mensagemError = (MobileElement) driver.findElement(erroId);
        return mensagemError.getText();
    }
}
