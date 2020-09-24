/*
	Classe que representa um agendamento de um recurso no sistema de agendamento de recursos
	
*/
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento implements Serializable
{
	// Atributos que todo agendamento deve ter
	private Recurso recurso;
	private Usuario usuario;
	private LocalDateTime inicio;
	private LocalDateTime termino;
	
	// Métodos de acesso
	public Recurso getRecurso() {	return this.recurso;	}
	public Usuario getUsuario() {	return this.usuario;	}
	public LocalDateTime getInicio() {	return this.inicio;	}
	public LocalDateTime getTermino() {	return this.termino;	}

	public void setRecurso(Recurso rec)	{	this.recurso = rec;	}
	public void setUsuario(Usuario usr)	{	this.usuario = usr;	}
	public void setInicio(String dthora) 
	{
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		this.inicio = LocalDateTime.parse(dthora,formatador);
	}
	public void setTermino(String dthora) 
	{
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		this.termino = LocalDateTime.parse(dthora,formatador);
	}

	public void mostraInfo()
	{
		System.out.println("| Recurso: " + this.recurso.getNome() + "  reservado pelo usuario " + this.usuario.getNome());
		System.out.println("| Data e hora inicial: " + this.inicio + "  Data e hora final: " + this.termino);
	}

}
