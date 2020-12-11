package fi.csc.pid.whatismyip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@SpringBootApplication
public class WhatismyipApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatismyipApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String myIP() {
		try {
			URL url = new URL("http://ww.whatismyipnumber.com/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(
  			new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
    			content.append(inputLine);
			}
			in.close();
			return content.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
