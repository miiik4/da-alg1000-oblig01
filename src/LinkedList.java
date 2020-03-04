package src;

public class LinkedList {
    
    Node head;

    // 01:	Slett et element først i listen.
    public Integer deleteFirstElement(){
        Integer returnValue = null;
        if(this.head != null){
            returnValue = this.head.data;
            this.head = this.head.next;
        }
        return returnValue;
    }

    // 02:	Legg til et element i slutten av listen.
    public Integer addLast(int input){
        Integer returnValue = null;
        if(this.head != null){
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(input);
            returnValue = temp.next.data;
            return returnValue;
        }
        this.head = new Node(input);
        returnValue = this.head.data;
        return returnValue;
    }

    // 03:	Slett et element i slutten av listen.
    public Integer deleteLastElement(){
        Integer returnValue = null;
        if(this.head != null && this.head.next != null){
            Node temp = this.head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            returnValue = temp.next.data;
            temp.next = null;
        } else if(this.head != null) {
            returnValue = head.data;
            head = null;
        }
        return returnValue;
    }

    // 04:	Slett et element med oppgitt verdi fra listen. 
    public void deleteElement(int input){
        if(this.head != null){
            Node temp = this.head;
            if(temp.data == input){
                this.head = temp.next;
            } else {
                while(temp.next != null){
                    if(temp.next.data == input){
                        temp.next = temp.next.next;
                        System.out.println("Vi har slettet ett element med verdi: "+input);
                        return;
                    }
                    temp = temp.next;
                }
                System.out.println("Fant ingen elementer med verdi: "+input);
            }
            return;
        }
        System.out.println("Listen er tom. Det er ikke mulig å slette element: "+input);
    }

    // 05:	Legg til et element etter et element med oppgitt verdi.
    public void addAfterValue(int input, int after){
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                if(temp.data == after){
                    Node holder = temp.next;
                    temp.next = new Node(input);
                    temp.next.next = holder;
                    System.out.println("Vi har lagt til ett element med verdi: "+input+" etter verdi: "+after);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Fant ingen elementer med verdi: "+after);
            return;
        }
        System.out.println("Listen er tom. Det er ikke mulig å finne: "+after);
    }

    // 06:	Legg til et element foran et element med oppgitt verdi.
    public void addBeforeValue(int input, int before){
        if(this.head != null){
            Node temp = this.head;
            if(temp.data == before){
                Node holder = temp;
                this.head = new Node(input);
                this.head.next = holder;
                System.out.println("Vi har lagt til ett element med verdi: "+input+" før verdi: "+before);

            } else {
                while(temp.next != null){
                    if(temp.next.data == before){
                        Node holder = temp.next;
                        temp.next = new Node(input);
                        temp.next.next = holder;
                        System.out.println("Vi har lagt til ett element med verdi: "+input+" før verdi: "+before);
                        return;
                    }
                    temp = temp.next;
                }
                System.out.println("Fant ingen elementer med verdi: "+before);
            }
            return;
        }
        System.out.println("Listen er tom. Det er ikke mulig å finne: "+before);
    }

    // 07:	Skriv ut lengden på listen.
    public void printLenght(String text){
        int count = 0;
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                count++;
                temp = temp.next;
            }
        }
        System.out.println(text+count);
    }

    // 08:	Tell opp antall forekomster av element  med gitt verdi i lista, dette antallet skrives ut.
    public void printElementCount(int input){
        int count = 0;
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                if(temp.data == input){
                    count++;
                } 
                temp = temp.next;
            }
        }
        System.out.println("Antall elementer med verdi '"+input+"' er: "+count);
    }

    // 09:	Skriv ut hele listen.
    public void printList(){

        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
            return;
        }
        System.out.println("Listen er tom..");
    }

    // 10:	Slett hele listen. Hvor mange elementer som ble slettet, skrives ut.
    public void deleteList(){
        printLenght("Antall slettede elementer var: ");
        this.head = null;
    }

}

class Node {

    public int data;
    public Node next;

    public Node(int input){
        this.data = input;
    }
}