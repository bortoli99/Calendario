package br.goc.ac.sefaz.calendario.dto;

import java.util.Objects;

public class EventosDTO {

	private String id;
	private String inicio;
	private String fim;
	private String descricao;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descricao, fim, inicio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventosDTO other = (EventosDTO) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(fim, other.fim)
				&& Objects.equals(inicio, other.inicio);
	}
	
	@Override
	public String toString() {
		return "EventosDTO [inicio=" + inicio + ", fim=" + fim + ", descricao=" + descricao + "]";
	}
	
	
	
}
