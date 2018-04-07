import java.util.Scanner;

public class Main {

    public static void workerMain(String[] args){
//        args = new String[]{""};
        double wynik;
        CalcObject zObiect;

        if(args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }

        String address = args[0];

        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        try{
            zObiect = (CalcObject) java.rmi.Naming.lookup(address);
        } catch (Exception e){
            System.out.println("Nie można pobrać referencji do " + address);
            e.printStackTrace();
            return;
        }
        System.out.println("Referencja do " + address + " jest pobrana.");

        try{
            wynik = zObiect.calculate(1.1, 2.2);
        } catch (Exception e){
            System.out.println("Blad zdalnego wywolania!");
            e.printStackTrace();
            return;
        }
        System.out.println("Wynik = " + wynik);
    }

    public static void farmerMain(String[] args){
        if(args.length == 0){
            System.out.println("You have to enter RMI object adress in the form //host_adress/service_name");
            return;
        }

        if(System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try{
            CalcObject impl = new CalcObject();
        } catch (Exception e){
            System.out.println("Server cannot be registered!");
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args){
        System.out.println("Farmer or Worker?[f/w]");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("f"))
            farmerMain(args);
        else if(choice.equals("w"))
            workerMain(args);
        else
            System.out.println("Bad choice, run the app again");
    }
}
