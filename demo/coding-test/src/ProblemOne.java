import java.util.List;

public class ProblemOne {

     Integer getSumWithForLoop(List<Integer> integerList){
        int sum = 0;
        for(int i = 0; i < integerList.size(); i++){
            sum += integerList.get(i);
        }
        return sum;
    }

     Integer getSumWithWhileLoop(List<Integer> integerList){
        int sum = 0;
        int count = 0;
        while(count < integerList.size()){
            sum += integerList.get(count);
            count++;
        }
        return sum;
    }

//    private Integer getSumWithRecursion(List<Integer> integerList){
//        for (Integer i: integerList) {
//            if(i > 0){
//                return i + getSumWithRecursion(integerList);
//            }
//        }
//        return null;
//    }
}
