import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObject extends UnicastRemoteObject implements ICalcObject{
    private static final long serialVersionUID = 101L;

    public CalcObject() throws RemoteException{
        super();
    }

    @Override
    public double calculate(double a, double b) throws RemoteException {
        return a + b;
    }
}

