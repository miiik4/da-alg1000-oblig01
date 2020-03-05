package com.netcode;

import java.awt.*;

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
    public Integer deleteElement(int input){
        Integer returnValue = null;
        if(this.head != null){
            Node temp = this.head;
            if(temp.data == input){
                returnValue = this.head.data;
                this.head = temp.next;
                return returnValue;
            } else {
                while(temp.next != null){
                    if(temp.next.data == input){
                        returnValue = temp.next.data;
                        temp.next = temp.next.next;
                        return returnValue;
                    }
                    temp = temp.next;
                }
            }
            return returnValue;
        }
        return returnValue;
    }

    // 05:	Legg til et element etter et element med oppgitt verdi.
    public Integer addAfterValue(int input, int after){
        Integer returnValue = null;
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                if(temp.data == after){
                    returnValue = temp.data;
                    Node holder = temp.next;
                    temp.next = new Node(input);
                    temp.next.next = holder;
                    return returnValue;
                }
                temp = temp.next;
            }
        }
        return returnValue;
    }

    // 06:	Legg til et element foran et element med oppgitt verdi.
    public Integer addBeforeValue(int input, int before){
        Integer returnValue = null;
        if(this.head != null){
            Node temp = this.head;
            if(temp.data == before){
                Node holder = temp;
                returnValue = temp.data;
                this.head = new Node(input);
                this.head.next = holder;
                return returnValue;
            } else {
                while (temp.next != null) {
                    if (temp.next.data == before) {
                        Node holder = temp.next;
                        returnValue = temp.next.data;
                        temp.next = new Node(input);
                        temp.next.next = holder;
                        return returnValue;
                    }
                    temp = temp.next;
                }
            }
        }
        return returnValue;
    }

    // 07:	Skriv ut lengden på listen.
    public Integer getLength(){
        Integer count = 0;
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    // 08:	Tell opp antall forekomster av element  med gitt verdi i lista, dette antallet skrives ut.
    public Integer printElementCount(int input){
        Integer count = 0;
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                if(temp.data == input){
                    count++;
                } 
                temp = temp.next;
            }
        }
        return count;
    }

    // 09:	Skriv ut hele listen.
    public String getList(){
        String returnValue = "";
        if(this.head != null){
            Node temp = this.head;
            while(temp != null){
                returnValue += temp.data;
                if(temp.next != null){
                    returnValue += ", ";
                }
                temp = temp.next;
            }
            return returnValue;
        }
        return null;
    }

    // 10:	Slett hele listen. Hvor mange elementer som ble slettet, skrives ut.
    public Integer deleteList(){
        Integer returnValue = getLength();
        this.head = null;
        return returnValue;
    }

}

class Node {

    public int data;
    public Node next;

    public Node(int input){
        this.data = input;
    }
}