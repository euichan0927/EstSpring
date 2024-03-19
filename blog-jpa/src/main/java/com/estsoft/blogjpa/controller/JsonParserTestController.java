// package com.estsoft.blogjpa.controller;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class JsonParserTestController {
//
// 	private ExternalApiParser externalApiParser;
// 	@Autowired
// 	public JsonParserTestController(ExternalApiParser externalApiParser) {
// 		this.externalApiParser = externalApiParser;
// 	}
//
// 	@GetMapping("/test")
// 	public String test(){
// 		externalApiParser.parser();
// 		return "Parsing completed";
// 	}
// }
