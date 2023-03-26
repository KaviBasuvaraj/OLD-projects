package org.runall;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features01", glue="org.stepdefinition",strict=true, dryRun=true)
public class RunAll {

}
