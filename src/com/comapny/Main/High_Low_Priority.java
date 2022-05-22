package com.comapny.Main;

public class High_Low_Priority {
    public static void main(String[] args){
        Priority mt1 = new Priority("High priority thread");
        Priority mt2 = new Priority("Thread with low priority");
        Priority mt3 = new Priority("Thread #1 with normal priority");
        Priority mt4 = new Priority("Thread #2 with normal priority");
        Priority mt5 = new Priority("Thread #3 with normal priority");
        //
        mt1.thread.setPriority(Thread.NORM_PRIORITY -4);
        mt2.thread.setPriority(Thread.NORM_PRIORITY +5);
        //
        mt1.thread.start();mt2.thread.start();mt3.thread.start();mt4.thread.start();mt5.thread.start();
        try {

            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
            mt1.thread.join();
            }
        catch (InterruptedException e) {
            System.out.println("The main thread starts running");
        }
            System.out.println("\n High priority thread counted to "+mt1.count);
            System.out.println("\n The low priority thread counted to "+mt2.count);
            System.out.println("\n #1 Normal Priority thread counted to "+mt3.count);
            System.out.println("\n #2 Normal Priority thread counted to "+mt4.count);
            System.out.println("\n #3 Normal Priority thread counted to "+mt5.count);
        }
    }
