import java.util.Arrays;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
import java.lang.reflect.Array;
import java.util.Iterator;

public class Time{

    public static void main(String args[]){
        /**
        *Create arrraylist, array and Vector
        */
        int array[] = new int[10000];
        ArrayList<Integer> arrayList =  new ArrayList<>();
        Vector<Integer> v = new Vector<>();
        /**
        *Test the running time of Arratlist.add() and Vector.addElement()
        */
        long startTimeAL = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Random number = new Random();
            arrayList.add(number.nextInt(10));
        }
        long endTimeAL = System.nanoTime();
        long durationAL = endTimeAL - startTimeAL;
        double secondsAL = (double) durationAL/1000000000.0;
        System.out.println("ArrayList add: " + secondsAL + "s");

        long startTimeV = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Random number = new Random();
            v.addElement(number.nextInt(10));
        }
        long endTimeV = System.nanoTime();
        long durationV = endTimeV - startTimeV;
        double secondsV = (double) durationV/1000000000.0;
        System.out.println("Vector addElement: " + secondsV + "s");

        long startTimeA = System.nanoTime();
        for(int i = 0; i <10000; i++){
            Random number = new Random();
            Arrays.fill(array, number.nextInt(10));
        }
        long endTimeA = System.nanoTime();
        long durationA = endTimeA - startTimeA;
        double secondA = (double) durationA/1000000000.0;
        System.out.println("Array fill: " + secondA + "s");
  
        /**
        *Test the running time of Arratlist.get() and Vector.get()
        */
        long startAL = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            arrayList.get(i);
        }
        long endAL = System.nanoTime();
        long durAL = endAL - startAL;
        double sedAL = (double) durAL/1000000000.0;
        System.out.println("ArrayList get: " + sedAL + "s");

        long startV = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            v.get(i);
        }
        long endV = System.nanoTime();
        long durV = endV - startV;
        double sedV = (double) durV/1000000000.0;
        System.out.println("Vector get: " + sedV + "s");

        long startA = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Array.get(array, i);
        }
        long endA = System.nanoTime();
        long durA =  endA - startA;
        double sedA = (double) durA/1000000000.0;
        System.out.println("Array get: " + sedA + "s");
        /**
        *Test the running time of Arraylist.remove() and Vector.remove()
        */
        long startRAL = System.nanoTime();
        for(int i = 9999; i >= 0; i--){
            arrayList.remove(i);
        }
        long endRAL = System.nanoTime();
        long durationRAL = endRAL - startRAL;
        double durRAL = (double) durationRAL/1000000000.0;
        System.out.println("Arraylist remove: " + durRAL + "s");

        long startTimeRV = System.nanoTime();
        for(int i = 9999; i >= 0; i--){
            v.remove(i);
        }
        long endTimeRV = System.nanoTime();
        long durationRV = endTimeRV - startTimeRV;
        double durRV = (double) durationRV/1000000000.0;
        System.out.println("Vector remove: " + durRV + "s");

        /**
        * Using iterator and loop to sum elements in arraylist, vector and array
        * and testing their iteration time
        */
        long iteratorstartAL = System.nanoTime();
        int sum = 0;
        Iterator<Integer> iteratorAL = arrayList.iterator();
        while(iteratorAL.hasNext()){
            int n = iteratorAL.next();
            sum += n;
        }
        long iteratorendAL = System.nanoTime();
        long iteratordurAL = iteratorendAL - iteratorstartAL;
        double iterAL = (double)iteratordurAL/1000000000.0;
        System.out.println("iteration time of arraylist is: " + iterAL +"s");

        long iteratorstartV = System.nanoTime();
        int sumV = 0;
        Iterator<Integer> iteratorV = v.iterator();
        while(iteratorV.hasNext()){
            int m = iteratorV.next();
            sumV += m;
        }
        long iteratorendV = System.nanoTime();
        long iteratordurV = iteratorendV - iteratorstartV;
        double iterV =(double) iteratordurV/1000000000.0;
        System.out.println("iteration time of vector is: " + iterV +"s");

        long iteratorstartA = System.nanoTime();
        int sumA =0;
        for(int i = 0; i < array.length; i++){
            sumA = sumA + array[i];
        }
        long iteratorendA = System.nanoTime();
        long iteratordurA = iteratorendA - iteratorstartA;
        double iterA = (double) iteratordurA/1000000000.0;
        System.out.println("iteration time of array is: " + iterA +"s");
    }
	
}