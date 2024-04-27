package com.org.currencyConverter.app;


import java.util.Scanner;
import java.util.InputMismatchException;

import java.io.IOException;
import java.lang.InterruptedException;

import com.org.currencyConverter.business.RequestingCurrency;
import com.org.currencyConverter.business.Currency;

public class Main {

    public static void main(String[] args){

        Scanner number = new Scanner(System.in);
        int selectedOption = 0;
        String rawResponse = "";
        boolean menu = true;
        Currency currency;

        while(menu) { 
            System.out.println("""
                    Welcome to Coin Converter =]
                    ---------------------------------
                    1) Dolar =>> Argentinian Peso
                    2) Argentinian Peso =>> Dolar
                    3) Brazilian Real =>> Dolar
                    4) Dolar =>> Brazilian Real
                    5) Colombian Peso =>> Dolar
                    7) Quit
                    
                    Choose an valid option:
                    """);
            try {
                selectedOption = number.nextInt();

                switch (selectedOption) {
                    case 1:
                        rawResponse = RequestingCurrency.request("USD", "ARS");
                        break;
                    case 2:
                        rawResponse = RequestingCurrency.request("ARS", "USD");
                        break;
                    case 3:
                        rawResponse = RequestingCurrency.request("BRL", "USD");
                        break;
                    case 4:
                        rawResponse = RequestingCurrency.request("USD", "BRL");
                        break;
                    case 5:
                        rawResponse = RequestingCurrency.request("COP", "USD");
                        break;
                    case 7:
                        menu = false;
                        break;
                }

                if(menu) {
                    System.out.println("Enter the value to convert: ");
                    int valueToConvert = number.nextInt();

                    currency = new Currency();
                    currency.clearJson(rawResponse);
                    System.out.println("\n==================================================");
                    System.out.println(valueToConvert + "[" + currency.getBaseCode() + "]"
                            + " >> " + String.format("%.2f", currency.convert(valueToConvert))
                            + "[" + currency.getTargetCode() + "]");
                    System.out.println("==================================================");
                }

            } catch(IOException | InterruptedException ex){
                System.out.println("Something went wrong: " + ex);
            }catch(InputMismatchException inputEx){
                System.out.println("""
                        =====================================
                        Input is not a valid option 
                        =====================================
                        """);
                number.nextLine();

            }

        }
    }
}
