/*
	Classe que representa um recurso no sistema de agendamento de recursos
	
*/
import java.io.*;
import java.util.*;

public class Recurso implements Serializable
{
	// Atributos que todo rcurso deve ter
	private String nome;
	private String descricao;
	private ArrayList<Agendamento> agendamentos;

	// Construtor
	public Recurso()
	{
		this.agendamentos = new ArrayList<Agendamento>();
	}

	// Métodos de acesso
	public String getNome() {	return this.nome;	}
	public String getDescricao() {	return this.descricao;	}
	public ArrayList<Agendamento> getAgendamentos()	{	return this.agendamentos;	}

	public void setNome(String nome)	{	this.nome = nome;	}
	public void setDescricao(String descr)	{	this.descricao = descr;	}
	public void setAgendamentos(Agendamento ag) {	this.agendamentos.add(ag);	}
	
	public void mostraInfo()
	{
		System.out.println("| Nome do recurso: " + this.nome);
		System.out.println("| Descricao: " + this.descricao);
		System.out.println("| Agendamentos registrados:");
		for(Agendamento a: this.agendamentos)
		{
			System.out.println("|  -Usuario: " + a.getUsuario().getNome() + "  Data inicial: " + a.getInicio() + "  Data final: " + a.getTermino());
		}
	}
}
