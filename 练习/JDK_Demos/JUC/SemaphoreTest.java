package com.JUC;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    static class Parking{
        //�ź���
        private Semaphore semaphore;

        Parking(int count){
            semaphore = new Semaphore(count);
        }

        public void park(){
            try {
                //��ȡ�ź���
                semaphore.acquire();
                long time = (long) (Math.random() * 10);
                System.out.println(Thread.currentThread().getName() + "����ͣ������ͣ��" + time + "��..." );
                Thread.sleep(time*1000);
                System.out.println(Thread.currentThread().getName() + "����ͣ����...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }


    static class Car extends Thread {
        Parking parking ;

        Car(Parking parking){
            this.parking = parking;
        }

        @Override
        public void run() {
            parking.park();     //����ͣ����
        }
    }

    public static void main(String[] args){
        Parking parking = new Parking(3);

        for(int i = 0 ; i < 5 ; i++){
            new Car(parking).start();
        }
    }
}
