package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {
    protected AppiumDriver driver;

    protected PageObjectBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract void BuscarElementos();

}
