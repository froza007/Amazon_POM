package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;


public class Hooks {

   
	@Before
	public void setup(){

	    BaseClass.setup();
	}


    @After
    public void tearDown(Scenario scenario){
    	
    	// Capture screenshot only when scenario fails
        if(scenario.isFailed()){

            ScreenshotUtil.captureScreenshot(
                    BaseClass.driver,
                    scenario.getName());
        }

        BaseClass.tearDown();
    }
}
