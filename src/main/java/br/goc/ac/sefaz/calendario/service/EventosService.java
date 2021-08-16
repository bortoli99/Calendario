package br.goc.ac.sefaz.calendario.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.goc.ac.sefaz.calendario.dto.EventosDTO;
import br.goc.ac.sefaz.calendario.model.Eventos;
import br.goc.ac.sefaz.calendario.repository.EventosRepository;

@Service
public class EventosService {

	@Autowired
	EventosRepository repository;

	@Transactional
	public void save(EventosDTO dto) throws ParseException {
		Eventos eventos = new Eventos();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		eventos.setInicio(new Timestamp(format.parse(dto.getInicio()).getTime()));
		eventos.setFim(new Timestamp(format.parse(dto.getFim()).getTime()));
		eventos.setDescricao(dto.getDescricao());

		repository.saveAndFlush(eventos);
	}

	@Transactional
	public void update(EventosDTO dto) throws ParseException {
		Eventos eventos = new Eventos();

		eventos.setId(Long.parseLong(dto.getId()));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		eventos.setInicio(new Timestamp(format.parse(dto.getInicio()).getTime()));

		eventos.setFim(new Timestamp(format.parse(dto.getFim()).getTime()));

		eventos.setDescricao(dto.getDescricao());

		repository.saveAndFlush(eventos);
	}

	@Transactional
	public void delet(Eventos eventos) {
		repository.delete(eventos);
	}
	
	public List<Eventos> getAll() {
		return repository.findAll();
	}

}
