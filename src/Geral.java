import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Geral extends Remote{

	public String opcoesAereas() throws RemoteException;
	
	public String mostraPassagens(boolean comEscala ) throws RemoteException;

	public String fazReserva(int m, boolean b) throws RemoteException;
}
