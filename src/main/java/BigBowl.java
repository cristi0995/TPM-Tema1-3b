import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BigBowl {
    List<String> food = new LinkedList<String>();

    public BigBowl(String input){
        String[] x = input.split(" ");
        food.addAll(Arrays.asList(x));
    }

    public synchronized String getFood(){
        if(food.size()>0){
            String x = this.food.get(food.size()-1);
            this.food.remove(food.size()-1);
            return x;
        }
        else
            return "-1";
    }

    public void refill() {
        String[] x = "333 444 555 666".split(" ");
        food.addAll(Arrays.asList(x));
    }
}
