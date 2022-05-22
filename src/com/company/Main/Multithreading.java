package com.company.Main;

class MyThread1 implements Runnable{
    Thread thread;
    MyThread1(String name){
        thread = new Thread(this, name);
    }

    public static MyThread1 createAndStart(String name){
        MyThread1 myThread1 = new MyThread1(name);
        myThread1.thread.start();
        return myThread1;
    }

    public void run(){
        System.out.println(thread.getName() + " Starts to operate");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(100);
                System.out.println(thread.getName() + " is executed, the counter value = " + count);
            }
        }catch (InterruptedException e){
            System.out.println(thread.getName() + " has been interrupted");
        }
        System.out.println(thread.getName() + " finished running.");

    }
}

class Multithreading {
    public static void main(String[] args) {
        System.out.println("The main thread starts running.");
        MyThread1 myThread1 = MyThread1.createAndStart("Child Thread *1");
        MyThread1 myThread2 = MyThread1.createAndStart("Child Thread *2");
        MyThread1 myThread3 = MyThread1.createAndStart("Child Thread *3");
        //for (int i = 0; i < 50; i++){
            //System.out.println("----------------");
            try{
                //Thread.sleep(100);
                myThread1.thread.join();
                myThread2.thread.join();
                myThread3.thread.join();
            } catch (InterruptedException e){
                System.out.println("The main thread has been terminated");
            }

        System.out.println("The main thread is exiting");
    }
}
