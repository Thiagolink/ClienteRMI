import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

	public static void main (String args[]) throws MalformedURLException, AlreadyBoundException, NotBoundException {
		Geral obj1, obj2, obj3, obj4;
		Scanner reader = new Scanner(System.in);
		try {
			// recuperando o objeto remoto via o servidor de nomes
			obj1 = (Geral) Naming.lookup("rmi://localhost/A");
			obj2 = (Geral) Naming.lookup("rmi://localhost/B");
			obj3 = (Geral) Naming.lookup("rmi://localhost/C");
			obj4 = (Geral) Naming.lookup("rmi://localhost/D");
			// invocando o método hello do servidor remoto
			while(true){
				System.out.println("Bem vindo, qual companhia aéra deseja selecionar?");
				System.out.println("1 - A"
						+ "2 - B"
						+ "3 - C"
						+ "4 - D");
				int n = reader.nextInt();
				switch(n){
					case 1:
						System.out.println(obj1.opcoesAereas());
					case 2:
						System.out.println(obj2.opcoesAereas());
					case 3:
						System.out.println(obj3.opcoesAereas());
					case 4:
						System.out.println(obj4.opcoesAereas());
				}
			}
			
		}
		catch (RemoteException e) {
			System.out.println("Erro" + e);
		}
	}
}
