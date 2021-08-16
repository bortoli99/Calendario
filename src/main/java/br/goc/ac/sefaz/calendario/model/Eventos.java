package br.goc.ac.sefaz.calendario.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Eventos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_inicio")
	private Timestamp inicio;
	
	@Column(name = "data_fim")
	private Timestamp fim;
	
	@Column
	private String descricao;
	
	
	public LocalDateTime fimLocal() {
		return fim.toLocalDateTime();
	}
	
	public LocalDateTime inicioLocal() {
		return inicio.toLocalDateTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFim() {
		return fim;
	}

	public void setFim(Timestamp fim) {
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
		return Objects.hash(descricao, fim, id, inicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eventos other = (Eventos) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(fim, other.fim)
				&& Objects.equals(id, other.id) && Objects.equals(inicio, other.inicio);
	}

	@Override
	public String toString() {
		return "Eventos [id=" + id + ", inicio=" + inicio + ", fim=" + fim + ", descricao=" + descricao + "]";
	}
	
}
