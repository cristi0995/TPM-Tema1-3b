public class MyThread extends Thread{
    BigBowl shared;
    TheCook cook;
    int number;
    FoodManager fm;

    public MyThread(BigBowl shared, TheCook cook,FoodManager fm, int number) {
        this.shared = shared;
        this.cook = cook;
        this.number = number;
        this.fm = fm;
    }

    public void processFood(String food){
        System.out.println("Thread "+number+" got: " + food);
    }

    public void  getsFood() throws InterruptedException {
        String food = fm.askForFood(this.number);
        if(food.equals("-1")){
            cook.emptyBowl = true;
            //cook.askForRefill();
            getsFood();
        }
        else {
            if(food.equals("0")){
                MyThread.yield();
                MyThread.sleep(500);
                getsFood();}
            else
                processFood(food);
        }
    }

    @Override
    public void run() {
        try {
            getsFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
