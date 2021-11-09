import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoodManager {
    private final int n;
    private BigBowl shared;
    int[] fed;
    String[] portions;
    int i;

    public FoodManager(BigBowl shared, int n){
        this.n = n;
        this.i = -1;
        this.shared = shared;
        this.portions = new String[n];  // locul unde punem mancarea pt threadul i
        this.fed = new int[n];  // reprezinta de cate ori a luat threadul i mancare
    }

    public int dealFood(){
        int[] x = new int[this.n];
        if (this.n >= 0) System.arraycopy(fed, 0, x, 0, this.n);
        Arrays.sort(x);
        int k=0;
        for(k=0; k<this.n; k++)
            if(fed[k]==x[0])
                break;
        this.portions[k] = shared.getFood();
        return k;
    }

    public synchronized String askForFood(int number){
        this.i = dealFood();

        String food;
        if(this.i==number) {
            food = this.portions[this.i];
            this.fed[i]++;
            this.portions[this.i] = "0";
            this.i=-1;
            return food;
        }
        else
            return "0";
    }
}
