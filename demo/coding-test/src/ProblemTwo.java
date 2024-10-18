import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemTwo {

    String strArray[] = {"a","b","c"};
    Integer intArray[] = {1,2,3};

    List<Object> combineList(){
        List<String> strings = Arrays.asList(strArray);
        List<Integer> integers = Arrays.asList(intArray);
        List<Object> combinedList = new ArrayList<>();
        for(int i = 0; i < Math.min(strings.size(), integers.size()); i++){
            combinedList.add(strings.get(i));
            combinedList.add(integers.get(i));
        }
        return combinedList;
    }
}
