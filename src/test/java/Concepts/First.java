package Concepts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.Baseclass;

public class First {
	Baseclass baseClass = new Baseclass();;
	String run;

	@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException {
		baseClass = new Baseclass();
		run = baseClass.getProperties().getProperty("run");
		if (run.equals("cloud")) {
			System.out.println("Docker Setup..");
			Runtime.getRuntime().exec("cmd /c start startDocker.bat");
			Thread.sleep(13000);
		} else {
			System.out.println("Executing on Local...");
		}
	}

	@AfterSuite
	public void afterSuite() throws IOException, InterruptedException {
		if (run.equals("cloud")) {
			System.out.println("Docker Down..");
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "stopDocker.bat");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			boolean completed = process.waitFor(30, TimeUnit.SECONDS); // Wait for up to 30 seconds
			if (completed) {
				System.out.println("stopDocker.bat executed successfully.");
			} else {
				System.out.println("stopDocker.bat did not complete within the timeout.");
			}
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		}
		else {
			System.out.println("Local Down...");
		}
	}
}
