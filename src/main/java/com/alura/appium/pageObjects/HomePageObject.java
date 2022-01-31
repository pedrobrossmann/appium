package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePageObject extends PageObjectBase {

    private final By botaoSairId;
    private MobileElement botaoSair;

    public HomePageObject(AppiumDriver driver){
        super(driver);
        botaoSairId = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
    }
    @Override
    public void BuscarElementos() {
        botaoSair = (MobileElement) driver.findElement(botaoSairId);
    }

    public void clicaBotaoSair() {
        botaoSair.click();
    }
}
