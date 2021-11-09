public class TheCook extends Thread{
    BigBowl shared;
    public volatile boolean emptyBowl = false;

    public TheCook(BigBowl shared){
        this.shared = shared;
    }


    @Override
    public void run() {
        while(true){
            if(this.emptyBowl){
                shared.refill();
                this.emptyBowl = false;
            }
        }
    }
}
