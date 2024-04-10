package service;

import datastr.MyHeap;
import model.Patient;

public class MainService {

    public static void main(String[] args) {
        MyHeap<Patient> myHeap = new MyHeap<>();
        try {
            myHeap.enqueue(new Patient("Janis", "Berzins", "130202-22222", 10));
            myHeap.enqueue(new Patient("Juris", "Buris", "130202-22222", 2));
            myHeap.enqueue(new Patient("Daniels", "Kalmars", "130202-22222", 5));
            myHeap.enqueue(new Patient("Rudolfs", "Sniedzins", "130202-22222", 9));
            myHeap.enqueue(new Patient("Juris", "Kalnins", "130202-22222", 1));

            myHeap.print();
            myHeap.printRecursive();
            System.out.println();
            myHeap.dequeue();
            myHeap.print();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
