public class Main {
    public static void main(String args[]){
        BigBowl b = new BigBowl("111 222");
        TheCook c = new TheCook(b);
        FoodManager fm = new FoodManager(b, 5);
        MyThread thread1 = new MyThread(b, c, fm, 0);
        MyThread thread2 = new MyThread(b, c, fm, 1);
        MyThread thread3 = new MyThread(b, c, fm, 2);
        MyThread thread4 = new MyThread(b, c, fm, 3);
        MyThread thread5 = new MyThread(b, c, fm, 4);
        c.start();
        while(true){
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
        }
    }
}
