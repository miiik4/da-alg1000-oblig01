package src;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String args[]){

        new Program();

    }
}

class Program {

    LinkedList list = new LinkedList();

    public Program(){
        String command = "0";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!command.equals("11")){

                
            printMenu();
            try {
                command = br.readLine();
            } catch(IOException e) {
                System.err.println(e);
            }

            System.out.print("\033\143");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex){}
            Integer returnValue = null;
            switch (command) {
                case "1":
                    returnValue = this.list.deleteFirstElement();
                    if(returnValue != null){
                        System.out.println("Elementet som har blitt slettet er: "+returnValue);
                    } else {
                        System.out.println("Listen er tom...");
                    }
                    break;
                case "2":
                    int value;
                    System.out.println("Skriv inn verdien du vil legge til:");
                    try {
                        value = Integer.parseInt(br.readLine());
                    } catch(IOException e){
                        break;
                    }
                    returnValue = this.list.addLast(value);
                    System.out.println("Verdien du la til er: "+returnValue);
                    break;
                case "3":
                    returnValue = list.deleteLastElement();
                    System.out.println("Siste element i listen som ble slettet er: "+returnValue);
                    break;
                case "4":
                    break;
                case "9":
                    System.out.println("Her er listen: ");
                    this.list.printList();
                    break;


                default:
                    break;
            }
        }
        
        System.out.println("You exited the program");
    }

    public void printMenu(){
        System.out.println("");
        System.out.println("-- Meny --");
        System.out.println("1.  Slett element først i listen");
        System.out.println("2.  Legg til element i slutten av listen");
        System.out.println("3.  Slett element i slutten av listen");
        System.out.println("4.  Slett element med oppgitt verdi fra listen");
        System.out.println("5.  Legg til element etter element med oppgitt verdi");
        System.out.println("6.  Legg til et element forran et element med oppgitt verdi");
        System.out.println("7.  Skriv ut lengden på listen");
        System.out.println("8.  Tell antall av oppgitt verdi");
        System.out.println("9.  Skriv ut hele listen");
        System.out.println("10. Slett hele listen");
        System.out.println("11. Avslutt programmet");
    }
}