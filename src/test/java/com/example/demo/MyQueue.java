package com.example.demo;

public class MyQueue {
    int [] elements;

    public MyQueue(){
        elements= new int[0];
    }
    public void  add(int element){
        int[] newArray= new int[elements.length+1];
        for (int i = 0; i <elements.length ; i++) {
            newArray[i]=elements[i];
        }
        newArray[elements.length]=element;

        elements= newArray;
    }
    public int pool(){
        if (elements.length==0) {
            throw new RuntimeException("栈中五元素");
        }
        int element=elements[0];
        int [] newArr=new int[elements.length-1];
        for (int i = 0; i <newArr.length ; i++) {
            newArr[i]=elements[i+1];
        }
        elements= newArr;
        return element;
    }
}
