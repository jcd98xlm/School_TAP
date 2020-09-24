import java.io.*;
import java.util.*;

public class Principal
{
	public static void main(String[] args)
	{
		
		Scanner teclado = new Scanner(System.in);
		Sistema sistema = Sistema.getInstancia();
		boolean continuar = true;
		String opcao;
		
		// Inicializa o sistema
		System.out.println("--------------------------------------------------");
		sistema.inicializaSistema();
		System.out.println("--------------------------------------------------");
		System.out.println("| DIGITE O NOME DO COMANDO OU O NUMERO RESPECTIVO");
		System.out.println("| Para ver os comandos disponiveis digite: ajuda ou 13");

		// Laco principal do programa
		do
		{
			System.out.printf("|-> ");
			opcao = teclado.nextLine();			
			if(opcao.equals("cadastra usuario") || opcao.equals("1"))
			{
				sistema.cadastraUsuario(teclado);
			}
			else if(opcao.equals("cadastra recurso") || opcao.equals("2"))
			{
				sistema.cadastraRecurso(teclado);
			}
			else if(opcao.equals("cadastra agendamento") || opcao.equals("3"))
			{
				sistema.cadastraAgendamento(teclado);
			}
			else if(opcao.equals("mostra usuarios") || opcao.equals("4"))
			{
				sistema.mostraUsuarios();
			}
			else if(opcao.equals("mostra recursos") || opcao.equals("5"))
			{
				sistema.mostraRecursos();
			}
			else if(opcao.equals("mostra agendamentos") || opcao.equals("6"))
			{
				sistema.mostraAgendamentos();
			}
			else if(opcao.equals("remove usuario") || opcao.equals("7"))
			{
				sistema.removeUsuario(teclado);
			}
			else if(opcao.equals("remove recurso") || opcao.equals("8"))
			{
				sistema.removeRecurso(teclado);
			}
			else if(opcao.equals("remove agendamento") || opcao.equals("9"))
			{
				sistema.removeAgendamento(teclado);
			}
			else if(opcao.equals("detalhes usuario") || opcao.equals("10"))
			{
				sistema.detalhesUsuario(teclado);
			}
			else if(opcao.equals("detalhes recurso") || opcao.equals("11"))
			{
				sistema.detalhesRecurso(teclado);
			}
			else if(opcao.equals("detalhes agendamento") || opcao.equals("12"))
			{
				sistema.detalhesAgendamento(teclado);
			}
			else if(opcao.equals("ajuda") || opcao.equals("13"))
			{
				sistema.mostraAjuda();
			}
			else if(opcao.equals("salvar dados") || opcao.equals("14"))
			{
				sistema.salvarDados();
			}
			else if(opcao.equals("sair") || opcao.equals("15"))
			{
				continuar = false;
			}
			else
			{
				System.out.println("|COMANDO INVALIDO, POR FAVOR DIGITE NOVAMENTE");
				System.out.println("--------------------------------------------------");
			}

		} while(continuar);

		// Finaliza o sistema
		sistema.finalizaSistema();
		
	
	}
}

/*
	System.out.println("|MOSTRANDO OPCOES DE COMANDOS:");
		System.out.println("|1. cadastra usuario");
		System.out.println("|2. cadastra recurso");
		System.out.println("|3. cadastra agendamento");
		System.out.println("|4. mostra usuarios");
		System.out.println("|5. mostra recursos");
		System.out.println("|6. mostra recursos disponiveis")
		System.out.println("|7. mostra agendamentos");
		System.out.println("|8. remove usuario");
		System.out.println("|9. remove recurso");
		System.out.println("|10. remove agendamento");
		System.out.println("|11. detalhes usuario");
		System.out.println("|12. detalhes recurso");
		System.out.println("|13. detalhes agendamento");
		System.out.println("|14. sair");
*/