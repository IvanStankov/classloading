package com.ivan.jmp;

import com.ivan.jmp.producer.GreetingProducer;
import com.ivan.jmp.producer.GreetingReloadableProducer;
import com.ivan.jmp.service.GreetingService;

import java.lang.reflect.Proxy;
import java.util.Scanner;

/**
 * Created by Ваня on 10.01.2016.
 */
public class ReloadingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("1 - Invoke method");
            System.out.println("2 - Reload and invoke method");
            System.out.println("0 - Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    System.out.println(GreetingReloadableProducer.getInstance().getService().getGreeting());
                    break;
                case 2:
                    System.out.println(GreetingReloadableProducer.getInstance().getService(true).getGreeting());
                    break;
                default:
                    System.out.println("Incorrect!");
            }
        }
    }

}
