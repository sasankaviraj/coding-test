import java.util.ArrayList;
import java.util.List;

public class ProblemThree
{
    List<Integer> computeFibonacci(int i, int j){
        List<Integer> fibList = new ArrayList<>();
        for(int k = 0; k < 100; k++){
            if(k == 0){
                fibList.add(i);
                fibList.add(j);
            }else {
                fibList.add(fibList.get(k-1) + fibList.get(k));
            }
        }
        return fibList;
    }
}
