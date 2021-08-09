package com.carlos.retoSQA.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features="src/test/resources/features/buscarVuelo.feature", glue= {"com.carlos.retoSQA"},tags= {"@CP001"})
public class runnerBuscarVueloAvianca {

}

