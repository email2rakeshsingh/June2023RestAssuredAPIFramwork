package com.qa.gorest.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.gorest.framworksexception.APIFreameworkExeption;

public class ConfigurationManager {

	private Properties prop;
	private FileInputStream ip;

	public Properties initProp() {
		prop = new Properties();
		String envName = System.getProperty("env");
		try {
			if (envName == null) {
				System.out.println("No env is given .... hence running test in QA env..");
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

			} else {
				System.out.println("Running test on env :" + envName);

				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/prod.config.properties");
					break;
				default:
					System.out.println("please pass the right env.. name :" + envName);
					throw new APIFreameworkExeption("No Env is Given");

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
