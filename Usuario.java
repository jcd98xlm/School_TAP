/*
	Classe que representa um usuário do sistema de agendamento de recursos
	
*/
import java.io.*;
import java.util.*;

public class Usuario implements Serializable
{
	public enum TipoUsuario 
	{
		ALUNO, PROFESSOR, ADMINISTRADOR;
			
	}

	// Construtor
	public Usuario()
	{
		this.agendamentos = new ArrayList<Agendamento>();
	}

	// Atributos que todo usuario deve ter
	private String nome;
	private String email;
	private String telefone; 
	private TipoUsuario tipo;
	private ArrayList<Agendamento> agendamentos;

	// Métodos de acesso
	public String getNome() {	return this.nome;	}
	public String getEmail() {	return this.email;	}
	public String getTelefone() {	return this.telefone;	}
	public TipoUsuario getTipo() {	return this.tipo;	}
	public ArrayList<Agendamento> getAgendamentos() {	return this.agendamentos;	}

	public void setNome(String nome)	{	this.nome = nome;	}
	public void setEmail(String email)	{	this.email = email;	}
	public void setTelefone(String telefone)	{	this.telefone = telefone;	}
	public void setTipo(String tipo)
	{	
		if (tipo.equals("ADMINISTRADOR") || tipo.equals("administrador"))		
			this.tipo = TipoUsuario.ADMINISTRADOR;
		else if (tipo.equals("PROFESSOR") || tipo.equals("professor"))
			this.tipo = TipoUsuario.PROFESSOR;
		else
			this.tipo = TipoUsuario.ALUNO;			
	}
	public void setAgendamentos(Agendamento ag) {	this.agendamentos.add(ag);	}

	public void mostraInfo()
	{
		System.out.println("| Nome: " + this.nome + "  Tipo: " + this.tipo.name());
		System.out.println("| Email: " + this.email + "  Telefone: " + this.telefone);
		System.out.println("| Agendamentos registrados:");
		for(Agendamento a: this.agendamentos)
		{
			System.out.println("|  -Recurso: " + a.getRecurso().getNome() + "  Data inicial: " + a.getInicio() + "  Data final: " + a.getTermino());
		}
	}

}
