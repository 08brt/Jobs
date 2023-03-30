package com.Unisys;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        WelcomeText();

        System.out.println("PRODUCTION - paste the 'T,B D' output and type quit at the end");
        Production production = new Production();

        System.out.println();
        System.out.println("DEVELOPMENT - paste the 'T,B D' output and type quit at the end");
        Development development = new Development();
    }

    private static void WelcomeText() {
        System.out.println();
        System.out.println();
        System.out.println("Unisys Program for Federale Job Check");
        System.out.println("On console type in 'T,B D'");
        System.out.println("Copy the output and paste it in below");
        System.out.println("***IMPORTANT***");
        System.out.println("Make sure to copy production and development into the correct area");
        System.out.println();
    }
}
