/*
	Classe que lida com leitura e escrita dos objetos usuario, recurso e agendamento em arquivos 

*/
import java.io.*;
import java.util.*;

public class Arquivo
{
	// Método que lê uma lista de ojectos do arquivo cujo nome foi passado como parametro
	public <T> ArrayList<T> leObjetos(String arqNome)
	{
		ArrayList<T> lista = new ArrayList<T>();
		try
		{
			FileInputStream arq = new FileInputStream(arqNome);
			ObjectInputStream in = new ObjectInputStream(arq);
			int tam = in.readInt();
			for(int i=0;i<tam;i++)
			{
				lista.add((T)in.readObject());
			}
			in.close();
			arq.close();
			return lista;
		}
		catch(java.io.IOException exc2)
		{
			System.out.println("Erro ao ler arquivo de objetos");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Classe nao encontrada ao ler arquivo de objetos");
		}		
		return lista;
	}

	// Método que grava uma lista de objetos no arquivo cujo nome foi passado como parametro
	public <T> void gravaObjetos(String arqNome, ArrayList<T> lista)
	{
		try
		{
			FileOutputStream arq = new FileOutputStream(arqNome);
			ObjectOutputStream out = new ObjectOutputStream(arq);
			out.writeInt(lista.size());
			for(T user: lista)
			{
				out.writeObject(user);
			}			
			out.flush();
			out.close();
			arq.close();
		}
		catch(java.io.IOException exc2)
		{
			System.out.println("Erro ao gravar o arquivo de objetos");
		}		
	}
}
/*
	// Método que lê uma lista de ojectos do arquivo cujo nome foi passado como parametro
	public <T> ArrayList<T> leObjetos(String arqNome)
	{
		ArrayList<T> lista = new ArrayList<T>();
		try
		{
			FileInputStream arq = new FileInputStream(arqNome);
			ObjectInputStream in = new ObjectInputStream(arq);
			int tam = in.readInt();
			for(int i=0;i<tam;i++)
			{
				lista.add((T)in.readObject());
			}
			in.close();
			arq.close();
			return lista;
		}
		catch(java.io.IOException exc2)
		{
			System.out.println("Erro ao ler arquivo de objetos");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Classe nao encontrada ao ler arquivo de objetos");
		}		
		return lista;
	}

	// Método que grava uma lista de objetos no arquivo cujo nome foi passado como parametro
	public <T> void gravaObjetos(String arqNome, ArrayList<T> lista)
	{
		try
		{
			FileOutputStream arq = new FileOutputStream(arqNome);
			ObjectOutputStream out = new ObjectOutputStream(arq);
			out.writeInt(lista.size());
			for(T user: lista)
			{
				out.writeObject(user);
			}			
			out.flush();
			out.close();
			arq.close();
		}
		catch(java.io.IOException exc2)
		{
			System.out.println("Erro ao gravar o arquivo de objetos");
		}		
	}
*/
