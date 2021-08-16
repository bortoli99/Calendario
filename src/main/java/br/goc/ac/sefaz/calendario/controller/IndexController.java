package br.goc.ac.sefaz.calendario.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.goc.ac.sefaz.calendario.dto.EventosDTO;
import br.goc.ac.sefaz.calendario.model.Eventos;
import br.goc.ac.sefaz.calendario.service.EventosService;

@Controller
public class IndexController {
	
	@Autowired
	EventosService service;
    
    @GetMapping("/")
    public String index(HttpServletRequest request){
    	request.setAttribute("eventos", service.getAll());
        return "index";
    }
    
    @PostMapping(value = "/save")
	public String saveEvento(EventosDTO evento) throws ParseException {
    	
    	System.out.println(evento.toString());
    	
    	service.save(evento);
    	
		return "redirect:/";
	}
    
    @PostMapping(value = "/edit")
	public String updateEvento(EventosDTO evento) throws ParseException {
    	
    	System.out.println(evento.toString());
    	
    	service.update(evento);
    	
		return "redirect:/";
	}
    
    @GetMapping("/delet/{id}")
    public String deletEvento(@PathVariable(name = "id") String id){
    	
    	Eventos eventos = new Eventos();
    	
    	eventos.setId(Long.parseLong(id));
    	
    	service.delet(eventos);
    	return "redirect:/";
    }
}
