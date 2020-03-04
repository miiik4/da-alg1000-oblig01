package com.netcode;
import java.awt.*;
import java.io.*;

public class LinkedListProgram {

    public static void main(String args[]) throws IOException, InterruptedException {

        new Program();
    }
}

class Program{

    LinkedList list = new LinkedList();

    public Program() throws IOException, InterruptedException {
        String command = "0";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!command.equals("11")){

            printMenu();
            command = br.readLine();

            Thread.sleep(100);

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
                    value = Integer.parseInt(br.readLine());
                    returnValue = this.list.addLast(value);
                    System.out.println("Verdien du la til er: "+returnValue);
                    break;
                case "3":
                    returnValue = list.deleteLastElement();
                    if(returnValue != null){
                        System.out.println("Siste element i listen som ble slettet er: "+returnValue);
                    } else {
                        System.out.println("Kunne ikke slette da listen er tom");
                    }
                    break;
                case "4":
                    System.out.println("Fyll inn verdien du ønsker å slette: ");
                    value = Integer.parseInt(br.readLine());
                    returnValue = list.deleteElement(value);
                    if(returnValue != null){
                        System.out.println("Verdien: "+returnValue+" har blitt slettet fra listen.");
                    } else {
                        System.out.println("Verdien du prøver å slette finnes ikke listen.");
                    }
                    break;
                case "5":
                    returnValue = null;
                    System.out.println("Fyll inn verdien du ønsker å legge til: ");
                    value = Integer.parseInt(br.readLine());
                    System.out.println("Fyll inn verdien du ønsker å legge til etter: ");
                    Integer after = Integer.parseInt(br.readLine());
                    returnValue = list.addAfterValue(value, after);
                    if(returnValue!= null){
                        System.out.println(value+" er lagt til etter verdien "+returnValue);
                    } else {
                        System.out.println("Fant ikke verien du ønsket å sette inn "+value+" etter.");
                    }
                    break;
                case "6":
                    returnValue = null;
                    System.out.println("Fyll inn verdien du ønsker å legge til: ");
                    value = Integer.parseInt(br.readLine());
                    System.out.println("Fyll inn verdien du ønsker å legge til før: ");
                    Integer before = Integer.parseInt(br.readLine());
                    returnValue = list.addBeforeValue(value, before);
                    if(returnValue!= null){
                        System.out.println(value+" er lagt til før verdien "+returnValue);
                    } else {
                        System.out.println("Fant ikke verien du ønsket å sette inn "+value+" før.");
                    }
                    break;
                case "7":

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
