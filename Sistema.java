/*
	Classe que representa e implementa as funcionalidades do sistema de agendamento de recursos, implementado no padrao singleton
*/

import java.io.*;
import java.util.*;

public class Sistema
{
	// Variaveis importantes
	private static Sistema instancia = null;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Recurso> recursos;
	private ArrayList<Agendamento> agendamentos;
	private Arquivo arq;
	private String arqUsuarios;
	private String arqRecursos;
	private String arqAgendamentos;

	// Construtor privado para o padrao singleton
	private Sistema()
	{
		this.usuarios = null;
		this.recursos = null;
		this.agendamentos = null;
		this.arq = null;
		this.arqUsuarios = "usuarios";
		this.arqRecursos = "recursos";
		this.arqAgendamentos = "agendamentos";
	}

	public static synchronized Sistema getInstancia()
	{
		if(instancia == null)
			instancia  = new Sistema();
		return instancia;
	}

	// Metodos de acesso
	public ArrayList<Usuario> getUsuarios() {	return this.usuarios;	}
	public ArrayList<Recurso> getRecursos() {	return this.recursos;	}
	public ArrayList<Agendamento> getAgendamentos() {	return this.agendamentos;	}

	// Funcao que inicializa os componentes basicos do sistema
	public void inicializaSistema()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| INICIALIZANDO O SISTEMA");

		// Alocando variaveis
		System.out.println("| Alocando variaveis internas: ");
		this.arq = new Arquivo();
		this.usuarios = new ArrayList<Usuario>();
		this.recursos = new ArrayList<Recurso>();
		this.agendamentos = new ArrayList<Agendamento>();

		// Carrega lista de usuarios
		System.out.printf("| Carregando lista de usuarios: ");
		carregaUsuarios();
		// carrega lista de recursos
		System.out.printf("| Carregando lista de recursos: ");
		carregaRecursos();
		// Carrega lista de agendamentos
		System.out.printf("| Carregando lista de agendamentos: ");
		carregaAgendamentos();

		System.out.println("| FIM DA INICIALIZACAO DO SISTEMA");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que finaliza o sistema
	public void finalizaSistema()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| FINALIZANDO O SISTEMA");
		// salva os dados
		salvarDados();
		System.out.println("| SISTEMA FINALIZADO");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que cadastra um usuario
	public void cadastraUsuario(Scanner tec)
	{
		Usuario user = new Usuario();
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o nome do usuario: ");
		user.setNome(tec.nextLine());
		System.out.printf("| Digite o email do usuario: ");
		user.setEmail(tec.nextLine());
		System.out.printf("| Digite o telefone do usuario: ");
		user.setTelefone(tec.nextLine());
		System.out.printf("| Digite o tipo do usuario (aluno,professor,administrador): ");
		user.setTipo(tec.nextLine());
		this.usuarios.add(user);
		System.out.println("| Usuario cadastrado com sucesso");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que cadastra um recurso
	public void cadastraRecurso(Scanner tec)
	{
		Recurso rec = new Recurso();
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o nome do recurso: ");
		rec.setNome(tec.nextLine());
		System.out.printf("| Digite a descricao do recurso: ");
		rec.setDescricao(tec.nextLine());
		this.recursos.add(rec);
		System.out.println("| Recurso cadastrado com sucesso");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que cadastra um agendamento
	public void cadastraAgendamento(Scanner tec)
	{
		Agendamento ag = new Agendamento();
		int num,n;
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do usuario: ");
		n = Integer.parseInt(tec.nextLine());

		// verifica se o usuario existe
		if((n < 0) || (n > this.usuarios.size()))
		{
			System.out.println("| Erro: o usuario digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		ag.setUsuario(this.usuarios.get(n));
		System.out.printf("| Digite o numero do recurso: ");
		num = Integer.parseInt(tec.nextLine());

		// verifica se existe o recurso
		if((num < 0) || (num > this.recursos.size()))
		{
			System.out.println("| Erro: o recurso digitado nao existe");
			return;
		}

		System.out.printf("| Digite a data e horario inicial da reserva no formato (dd-MM-yyyy HH:mm): ");
		ag.setInicio(tec.nextLine());
		System.out.printf("| Digite a data e horario final da reserva no formato (dd-MM-yyyy HH:mm): ");
		ag.setTermino(tec.nextLine());

		// verifica se o recurso ja esta reservado para a data e horario informados
		for(Agendamento a: this.recursos.get(num).getAgendamentos())
		{
			if((ag.getInicio().isBefore(a.getInicio()) &&  a.getInicio().isBefore(ag.getTermino())) || (ag.getInicio().isBefore(a.getTermino()) &&  a.getTermino().isBefore(ag.getTermino())) || (ag.getInicio().isBefore(a.getInicio()) && ag.getTermino().isAfter(a.getTermino())) || (ag.getInicio().isAfter(a.getInicio()) && ag.getTermino().isBefore(a.getTermino())))
			{
				System.out.println("| Erro: o recurso desejado nao esta disponivel na data desejada");
				System.out.println("--------------------------------------------------");
				return;
			}
		}

		ag.setRecurso(this.recursos.get(num));
		// Coloca o agendamento na lista de agendamentos
		this.agendamentos.add(ag);
		// Coloca o agendamento na lista propria do recurso
		this.recursos.get(num).setAgendamentos(ag);
		// Coloca o agendamento na lista propria do usuario
		this.usuarios.get(n).setAgendamentos(ag);
		System.out.println("| Agendamento cadastrado com sucesso");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que mostra as opcoes para o usuario
	public void mostraAjuda()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| MOSTRANDO OPCOES DE COMANDOS:");
		System.out.println("| 1. cadastra usuario");
		System.out.println("| 2. cadastra recurso");
		System.out.println("| 3. cadastra agendamento");
		System.out.println("| 4. mostra usuarios");
		System.out.println("| 5. mostra recursos");
		System.out.println("| 6. mostra agendamentos");
		System.out.println("| 7. remove usuario");
		System.out.println("| 8. remove recurso");
		System.out.println("| 9. remove agendamento");
		System.out.println("| 10. detalhes usuario");
		System.out.println("| 11. detalhes recurso");
		System.out.println("| 12. detalhes agendamento");
		System.out.println("| 13. ajuda");
		System.out.println("| 14. salvar dados");
		System.out.println("| 15. sair");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que lista todos os usuarios
	public void mostraUsuarios()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| LISTANDO TODOS OS USUARIOS CADASTRADOS");
		for(Usuario user: this.usuarios)
		{
			System.out.println("| "+ this.usuarios.indexOf(user) +": "+ user.getNome());
		}
		System.out.println("--------------------------------------------------");
	}

	// Funcao que lista todos os recursos
	public void mostraRecursos()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| LISTANDO TODOS OS RECURSOS CADASTRADOS");
		for(Recurso rec: this.recursos)
		{
			System.out.println("| "+ this.recursos.indexOf(rec) +": "+ rec.getNome());
		}
		System.out.println("--------------------------------------------------");
	}

	// Funcao que lista todos os agendamentos
	public void mostraAgendamentos()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| LISTANDO TODOS OS AGENDAMENTOS CADASTRADOS");
		for(Agendamento ag: this.agendamentos)
		{
			System.out.println("| "+ this.agendamentos.indexOf(ag) +": Recurso: "+ ag.getRecurso().getNome() + "   Usuario: " + ag.getUsuario().getNome());
		}
		System.out.println("--------------------------------------------------");
	}

	// Funcao que remove um usuario da lista de usuarios
	public void removeUsuario(Scanner tec)
	{
		int num;
		Usuario user = new Usuario();
		Recurso rec = new Recurso();
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do usuario a ser removido: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.usuarios.size())
		{
			System.out.println("| Erro: o usuario digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		user = this.usuarios.get(num);
		// testar se tem agendamentos desse usuario e lidar com eles
		if(user.getAgendamentos().size() > 0)
		{
			int n,i=0;
			for(Agendamento a: user.getAgendamentos())
			{
				// procura pelo agendamento na lista geral
				n = procuraAgendamento(a,this.agendamentos);
				if(n < 0)
				{
					System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
					System.out.println("--------------------------------------------------");
					return;
				}
				else
				{
					i++;
					this.agendamentos.remove(n);
				}
				// procura pelo agendameto na lista de agendamentos do recurso
				rec = a.getRecurso();
				n = procuraAgendamento(a,rec.getAgendamentos());
				if(n < 0)
				{
					System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
					System.out.println("--------------------------------------------------");
					return;
				}
				else
				{
					rec.getAgendamentos().remove(n);
				}
			}
			System.out.println("| -Foram removidos " + i + " agendamentos referentes a esse usuario");
		} 
		this.usuarios.remove(user);
		System.out.println("| Usuario numero " + num + " removido com sucesso");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que remove um recurso da lista de recursos
	public void removeRecurso(Scanner tec)
	{
		int num;
		Recurso rec = new Recurso();
		Usuario user = new Usuario();
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do recurso a ser removido: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.recursos.size())
		{
			System.out.println("| Erro: o recurso digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		rec = this.recursos.get(num);
		// testa se tem agendamentos cadastrados para esse recurso e lida com eles
		if(rec.getAgendamentos().size() > 0)
		{
			int n,i =0;
			for(Agendamento a: rec.getAgendamentos())
			{
				// procura pelo agendamento na lista geral
				n = procuraAgendamento(a,this.agendamentos);
				if(n < 0)
				{
					System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
					System.out.println("--------------------------------------------------");
					return;
				}
				// exclui o agendamento da lista geral
				else
				{
					i++;
					this.agendamentos.remove(n);
				}
				// procura pelo agendamento na lista de agendamentos do usuario
				user = a.getUsuario();
				n = procuraAgendamento(a,user.getAgendamentos());
				if(n < 0)
				{
					System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
					System.out.println("--------------------------------------------------");
					return;
				}
				else
				{
					user.getAgendamentos().remove(n);
				}
			}
			System.out.println("| -Foram removidos " + i + " agendamentos referentes a esse recurso");
		}
		this.recursos.remove(rec);
		System.out.println("| Recurso numero " + num + " removido com sucesso");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que remove um agendamento da lista de agendamentos
	public void removeAgendamento(Scanner tec)
	{
		int num,n,m;
		Recurso rec = new Recurso();
		Agendamento ag = new Agendamento();
		Usuario user = new Usuario();
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do agendamento a ser removido: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.agendamentos.size())
		{
			System.out.println("| Erro: o agendamento digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		ag = this.agendamentos.get(num);
		rec = ag.getRecurso();
		user = ag.getUsuario();

		// procura o agendamento que esta sendo excluido na lista propria do recurso
		n = procuraAgendamento(ag,rec.getAgendamentos());
		if(n < 0)
		{
			System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
			System.out.println("--------------------------------------------------");
			return;
		}
		
		// procura o agendamento que esta sendo excluido na lista propria do usuario
		m = procuraAgendamento(ag,user.getAgendamentos());
		if(m < 0)
		{
			System.out.println("| ERRO AO PROCURAR O AGENDAMENTO PARA EXCLUIR");
			System.out.println("--------------------------------------------------");
			return;
		}

		// remove o agendamento na lista propria do recurso
		rec.getAgendamentos().remove(n);
		// remove o agendamento na lista propria do usuario
		user.getAgendamentos().remove(m);
		// remove o agendamento da lista geral
		this.agendamentos.remove(num);
		System.out.println("| Agendamento numero " + num + " removido com sucesso");
		System.out.println("--------------------------------------------------");		
	}

	// Funcao que mostra detalhadamente os dados de um usuario
	public void detalhesUsuario(Scanner tec)
	{
		int num;
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do usuario que deseja informacoes: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.usuarios.size())
		{
			System.out.println("| Erro: o usuario digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		this.usuarios.get(num).mostraInfo();
		System.out.println("--------------------------------------------------");

	}

	// Funcao que mostra detalhadamente os dados de um recurso
	public void detalhesRecurso(Scanner tec)
	{
		int num;
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do recurso que deseja informacoes: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.recursos.size())
		{
			System.out.println("| Erro: o recurso digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		this.recursos.get(num).mostraInfo();
		System.out.println("--------------------------------------------------");

	}

	// Funcao que mostra detalhadamente os dados de um agendamento
	public void detalhesAgendamento(Scanner tec)
	{
		int num;
		System.out.println("--------------------------------------------------");
		System.out.printf("| Digite o numero do agendamento que deseja informacoes: ");
		num = Integer.parseInt(tec.nextLine());
		if(num < 0 || num >= this.agendamentos.size())
		{
			System.out.println("| Erro: o agendamento digitado nao existe");
			System.out.println("--------------------------------------------------");
			return;
		}
		this.agendamentos.get(num).mostraInfo();
		System.out.println("--------------------------------------------------");

	}

	// Funcao que salva os dados nos arquivos a qualquer momento
	public void salvarDados()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("| SALVANDO OS DADOS NOS ARQUIVOS");
		// Salva a lista de usuarios
		System.out.printf("| Gravando a lista de usuarios no arquivo: ");
		salvaUsuarios();
		// Salva a lista de recursos
		System.out.printf("| Gravando a lista de recursos no arquivo: ");
		salvaRecursos();
		// Salva a lista de agendamentos
		System.out.printf("| Gravando a lista de agendamentos no arquivo: ");
		salvaAgendamentos();
		System.out.println("| TERMINO DO SALVAMENTO ");
		System.out.println("--------------------------------------------------");
	}

	// Funcao que serve para carregar a lista de usuarios
	private void carregaUsuarios()
	{
		this.usuarios = this.arq.leObjetos(arqUsuarios);
		if(this.usuarios == null)
			System.out.println("Erro ao carregar lista de usuarios");
		else
			System.out.println("| A lista de usuarios foi carregada sem problemas");
	}

	// Funcao que serve para carregar a lista de recursos
	private void carregaRecursos()
	{
		this.recursos = this.arq.leObjetos(arqRecursos);
		if(this.recursos == null)
			System.out.println("Erro ao carregar lista de recursos");
		else
			System.out.println("| A lista de recursos foi carregada sem problemas");
	}

	// Funcao que serve para carregar a lista de agendamentos
	private void carregaAgendamentos()
	{
		this.agendamentos = this.arq.leObjetos(arqAgendamentos);
		if(this.agendamentos == null)
			System.out.println("Erro ao carregar lista de agendamentos");
		else
			System.out.println("| A lista de agendamentos foi carregada sem problemas");
	}

	// Funcao que salva a lista de usuarios no arquivo
	private void salvaUsuarios()
	{
		this.arq.gravaObjetos(arqUsuarios,this.usuarios);
		System.out.println("| O arquivo de usuarios foi gravado com sucesso");
	}

	// Funcao que salva a lista de recursos no arquivo
	private void salvaRecursos()
	{
		this.arq.gravaObjetos(arqRecursos,this.recursos);
		System.out.println("| O arquivo de recursos foi gravado com sucesso");
	}

	// Funcao que salva a lista de agendamentos no arquivo
	private void salvaAgendamentos()
	{
		this.arq.gravaObjetos(arqAgendamentos,this.agendamentos);
		System.out.println("| O arquivo de agendamentos foi gravado com sucesso");
	}

	// Funcao que procura por um agendamento na lista dada e devolve o seu indice
	private int procuraAgendamento(Agendamento ag, ArrayList<Agendamento> l)
	{
		int n;
		for(int i=0;i<l.size();i++)
		{
			// Atencao essa e uma comparacao de referencias, nao de objetos
			if(ag == l.get(i))
				return i;
		}
		return -1;
	}
}
