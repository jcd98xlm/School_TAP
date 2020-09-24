import java.io.*;
import java.util.*;

public class teste
{
	
	public static void main(String args[])
	{
		
	}
}
/*
	Usuario aluno = new Usuario();
		Usuario professor = new Usuario();
		Usuario cobaia = new Usuario();
		Recurso projetor = new Recurso();
		Agendamento ag = new Agendamento();
		Scanner teclado = new Scanner(System.in);
		Arquivo arq = new Arquivo();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ArrayList<Usuario> lista_volta = new ArrayList<Usuario>();

		System.out.print("Digite o nome do usuario1: ");
		aluno.setNome(teclado.nextLine());
		System.out.print("Digite o email do usuario1: ");
		aluno.setEmail(teclado.nextLine());
		System.out.print("Digite o telefone do usuario1: ");
		aluno.setTelefone(teclado.nextLine());
		System.out.print("Digite o tipo do usuario1: ");
		aluno.setTipo(teclado.nextLine());
		lista.add(aluno);

		System.out.print("-Digite o nome do usuario2: ");
		professor.setNome(teclado.nextLine());
		System.out.print("-Digite o email do usuario2: ");
		professor.setEmail(teclado.nextLine());
		System.out.print("-Digite o telefone do usuario2: ");
		professor.setTelefone(teclado.nextLine());
		System.out.print("-Digite o tipo do usuario2: ");
		professor.setTipo(teclado.nextLine());
		lista.add(professor);


		System.out.println("------------------------------------------");
		System.out.println("nome do usuario 1: " + aluno.getNome());
		System.out.println("email do usuario 1: " + aluno.getEmail());
		System.out.println("telefone do usuario 1: " + aluno.getTelefone());
		System.out.println("tipo do usuario 1: " + aluno.getTipo().name());
		System.out.println("");
		System.out.println("nome do usuario 2: " + professor.getNome());
		System.out.println("email do usuario 2: " + professor.getEmail());
		System.out.println("telefone do usuario 2: " + professor.getTelefone());
		System.out.println("tipo do usuario 2: " + professor.getTipo().name());
		
		System.out.println("------------------------------------------");
		System.out.println("Tentando gravar o arquivo de usuarios");
		arq.gravaObjetos("usuarios",lista);
		System.out.println("Gravei o arquivo");

		System.out.println("------------------------------------------");
		System.out.println("Tentando ler o arquivo de usuarios");
		lista_volta = arq.leObjetos("usuarios");
		System.out.println("Li o arquivo");

		System.out.println("------------------------------------------");
		System.out.println("Mostrando resultado vindo do arquivo");
		for(int i=0; i<lista_volta.size();i++)
		{
			cobaia = lista_volta.get(i);
			System.out.println("nome do usuario " + i + ": "  + cobaia.getNome());
			System.out.println("email do usuario " + i + ": " + cobaia.getEmail());
			System.out.println("telefone do usuario " + i + ": " + cobaia.getTelefone());
			System.out.println("tipo do usuario " + i + ": " + cobaia.getTipo().name());
			System.out.println("");
		}
		
		System.out.print("Digite o nome do recurso: ");
		projetor.setNome(teclado.nextLine());
		System.out.print("Digite a descricao do recurso: ");
		projetor.setDescricao(teclado.nextLine());
		
		ag.setUsuario(aluno);
		ag.setRecurso(projetor);
		System.out.print("Digite o dia de retirada do recurso (dd-MM-yyyy HH:mm): ");
		ag.setInicio(teclado.nextLine());
		System.out.print("Digite o dia de devolução do recurso (dd-MM-yyyy HH:mm): ");
		ag.setTermino(teclado.nextLine());
		
		System.out.println("------------------------------------------");
		System.out.println("MOSTRANDO O RESULTADO: ");
		System.out.println("nome do usuario: " +  ag.getUsuario().getNome());
		System.out.println("nome do recurso: " + ag.getRecurso().getNome());
		System.out.println("descricao do recurso: " + ag.getRecurso().getDescricao());
		System.out.println("dia e hora inicial: " + ag.getInicio());
		System.out.println("dia e hora final" + ag.getTermino());
		
		System.out.println("------------------------------------------");
		System.out.println("FIM DOS TESTES ");
	}
*/