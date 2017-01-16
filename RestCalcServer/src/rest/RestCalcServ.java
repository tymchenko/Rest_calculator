package rest;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class RestCalcServ {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{name}")
	public String sayHelloXML(@PathParam("name") String name){
		String response = "<?xml version='1.0'?>"	
				+ "<number>" + calculate(parse(name.trim()))+ "</number>";
		return response;
	}

	private int calculate(String [] params) {
		int number1 = Integer.parseInt(params[0]);
		int number2 = Integer.parseInt(params[2]);
		
		int ans = 0;
		switch(params[1]){
			case "+":
				System.out.println(params[1]);
				return number1 + number2;
			case "-":
				return number1 - number2;
			case "*":
				return number1 * number2;
		}
		return ans;
	}

	private String [] parse(String name) {
		String sign = getSign(name);
		String number1 = getNumber(name, 0, name.indexOf(sign));
		String number2 = getNumber(name, name.indexOf(sign), name.length());
		return new String [] {number1, sign, number2};
	}

	private String getSign(String name) {
		CharSequence [] signs = {"+", "-", "*", "\\"};
		for(CharSequence i : signs){
			if (name.contains(i)){
				return i.toString();
			}
		}
		return "sign";		
	}

	private String getNumber(String str, int start, int finish) {
		String number = new String();
		char [] nameArr = str.substring(start, finish).toCharArray();
		
		for(char k : nameArr){
			if(Character.isDigit(k)){
				number += k;
			}
		}
		return number;
	}
}