package com.example.demo;

public class MyStack {
    int [] elements;

    public MyStack(){
        elements= new int[0];
    }

    public void  push (int  element){
        int[] newArray= new int[elements.length+1];
        for (int i = 0; i <elements.length ; i++) {
            newArray[i]=elements[i];
        }
        newArray[elements.length]=element;

        elements= newArray;
    }

    public int pop(){
        if (elements.length==0) {
            throw new RuntimeException("栈中五元素");
        }
        int element=elements[elements.length-1];
        int [] newArr=new int[elements.length-1];
        for (int i = 0; i <elements.length-1 ; i++) {
            newArr[i]=elements[i];
        }
        elements= newArr;
        return element;
    }
    public int peep(){
        return elements[elements.length-1];
    }
    public boolean isEmpty(){
        return  elements.length==0?true:false;

    }
}
