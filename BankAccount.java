/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atminterface;


public class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    public boolean deposit(double amount){
        if(amount>0){
            balance+=amount;
            return true;
        }
        else
            return false;
    }
    public boolean withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
            return true;
        }
        else
            return false;
    }
    public double checkBalance(){
        return balance;
    }
}