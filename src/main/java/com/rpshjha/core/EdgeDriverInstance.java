package com.rpshjha.core;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;

@Log
public class EdgeDriverInstance {

	public static EdgeDriver createDriverUsingEdge() {
		log.info("Opening the browser : Edge");
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}

}
