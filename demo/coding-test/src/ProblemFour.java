import java.util.Collections;
import java.util.List;

public class ProblemFour {

    StringBuilder largestPosibleNo(List<Integer> numbers){
        Collections.sort(numbers, (o1, o2) -> o2.compareTo(o1));
        StringBuilder stringBuilder = new StringBuilder();
        numbers.forEach(integer -> stringBuilder.append(integer.toString()));
        return stringBuilder;
    }
}
