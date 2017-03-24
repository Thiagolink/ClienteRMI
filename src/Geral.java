import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Geral extends Remote{

	public String hello(String teste) throws RemoteException;
	
	public void incial(String companhia) throws RemoteException;
}
