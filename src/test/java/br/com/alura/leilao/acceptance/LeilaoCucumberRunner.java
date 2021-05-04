package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Cucumber docs
//https://cucumber.io/docs/cucumber/
//https://cucumber.io/docs/cucumber/step-definitions/
//https://cucumber.io/docs/gherkin/reference/?sbsearch=spoken%20language#spoken-languages
//https://cucumber.io/docs/gherkin/languages/

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class LeilaoCucumberRunner {

}
