package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Cucumber docs
//https://cucumber.io/docs/cucumber/
//https://cucumber.io/docs/cucumber/step-definitions/

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class LeilaoCucumberRunner {

}
