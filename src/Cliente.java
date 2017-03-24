import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

	public static void main (String args[]) throws MalformedURLException, AlreadyBoundException, NotBoundException {
		Geral obj;
		Geral obj1;
		Scanner reader = new Scanner(System.in);
		try {
			// recuperando o objeto remoto via o servidor de nomes
			obj = (Geral) Naming.lookup("rmi://localhost/HelloWordServer");
			obj1 = (Geral) Naming.lookup("rmi://localhost/Teste");
			// invocando o método hello do servidor remoto
				System.out.println("Bem vindo, qual companhia aéra deseja selecionar?");
				int n = reader.nextInt();
				if(n == 1){
					System.out.println(obj1.hello("asd"));
					obj1.incial();
				}
				if(n == 2)
					System.out.println(obj.hello("teste"));	
			}
		catch (RemoteException e) {
			System.out.println("Erro" + e);
		}
	}
}
