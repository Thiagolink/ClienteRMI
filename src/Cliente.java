import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

	Scanner reader = new Scanner(System.in);
	
	public static void main (String args[]) throws MalformedURLException, AlreadyBoundException, NotBoundException, RemoteException {
		Geral obj1, obj2, obj3, obj4;
		Geral objEscolhido = (Geral) Naming.lookup("rmi://localhost/B");

		// recuperando o objeto remoto via o servidor de nomes
		obj1 = (Geral) Naming.lookup("rmi://localhost/A");
		obj2 = (Geral) Naming.lookup("rmi://localhost/B");
		obj3 = (Geral) Naming.lookup("rmi://localhost/C");
		obj4 = (Geral) Naming.lookup("rmi://localhost/D");
		
		int n;
		boolean reiniciaReserva = false;
		do{
			Scanner reader = new Scanner(System.in);
			// invocando o m�todo hello do servidor remoto
			boolean repeteIteracao;
			do{
				repeteIteracao = false;
				System.out.println("Bem vindo, qual companhia a�ra deseja selecionar?");
				System.out.println("1 - A\n"
						+ "2 - B\n"
						+ "3 - C\n"
						+ "4 - D\n");
				n = reader.nextInt();
				switch(n){
					case 1:
						objEscolhido = obj1;
						System.out.println(obj1.opcoesAereas());
						break;
					case 2:
						objEscolhido = obj2;
						System.out.println(obj2.opcoesAereas());
						break;
					case 3:
						objEscolhido = obj3;
						System.out.println(obj3.opcoesAereas());
						break;
					case 4:
						objEscolhido = obj4;
						System.out.println(obj4.opcoesAereas());
						break;
					default:
						repeteIteracao = true;
						System.out.println("Por favor, entre apenas com n�meros de 1 at� 7");
				}
			}while(repeteIteracao);
			
			do{
				repeteIteracao = false;
				System.out.println("1 - V�os com escala" + "\n" + "2 - V�os sem escala");
				n = reader.nextInt();
				if(n!=1 && n!=2){
					repeteIteracao = true;
					System.out.println("Por favor, entre apenas com 1 ou 2");
				}
			}while(repeteIteracao);

			System.out.println(objEscolhido.mostraPassagens( n==1 ? true : false));
			System.out.println("Fa�a sua reserva entrando com o d�gito respectivo a passagem que deseja");

			int m;
			do{
				repeteIteracao = false;
				m = reader.nextInt();
				if( ((m<1 || m>5) && n==2 ) || ((m<6 || m>7) && n==1)){
					repeteIteracao = true;
					if(n==2)
						System.out.println("Por favor, entre apenas com n�meros de 1 at� 5");
					if(n==1)
						System.out.println("Por favor, entre apenas com n�meros de 6 at� 7");
				}
			}while(repeteIteracao);
			
			System.out.println( objEscolhido.fazReserva(m, n==1 ? true : false) );
			
			System.out.println("Deseja realizar outra reserva em outra companhia a�rea? \n"
					+ "1 - Sim \n"
					+ "2 - N�o");

			do{
				repeteIteracao = false;
				n = reader.nextInt();
				if( n!=1 && n!=2){
					repeteIteracao = true;
					System.out.println("Por favor, entre apenas com 1 ou 2");
				}
			}while(repeteIteracao);
			
			if(n==1)
				reiniciaReserva = true;
			else
				reiniciaReserva = false;
			
			//reader.close();
			
		}while(reiniciaReserva);

	}
	
}
