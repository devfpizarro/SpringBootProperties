package com.cristianruizblog.propertiesProject.Controller;

import java.awt.List;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class DemoController {
	
	@Value("${com.cristianruizblog.titulo}")
	private String titulo;
	
	@Value("${com.cristianruizblog.util.cont.post}")
	private String cont;
	
	@Value("${com.cristianruizblog.message}")
	private String message;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("mititulo", titulo);
		modelo.addAttribute("segundoValor",cont);
		modelo.addAttribute("message", message);
		
		return "index";
	}
	
	@GetMapping("/getMessage")
	public String getMessage(Model model) {

	    model.addAttribute("message", message);

	    return "model";
	}
	
	
	@GetMapping("/tweets-blocking")
	@ResponseBody
	public ResponseEntity<ObjectNode> getTweetsBlocking() {
	    final String uri = message;

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<ObjectNode> response = restTemplate.exchange(
	      uri, HttpMethod.GET, null, ObjectNode.class );
	    
		return response;
	}
}
