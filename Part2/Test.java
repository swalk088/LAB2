import java.util.Arrays;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
import java.lang.reflect.Array;

public class Test{

    public static void main(String args[]){
        /**
        *Create arrraylist, array and Vector
        */
        int array[] = new int[10000];
        ArrayList arrayList =  new ArrayList();
        Vector v = new Vector();
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
        System.out.println("ArrayList add: " + durationAL);

        long startTimeV = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Random number = new Random();
            v.addElement(number.nextInt(10));
        }
        long endTimeV = System.nanoTime();
        long durationV = endTimeV - startTimeV;
        System.out.println("Vector addElement: " + durationV);

        long startTimeA = System.nanoTime();
        for(int i = 0; i <10000; i++){
            Random number = new Random();
            Arrays.fill(array, number.nextInt(10));
        }
        long endTimeA = System.nanoTime();
        long durationA = endTimeA - startTimeA;
        System.out.println("Array fill: " + durationA);
  
        /**
        *Test the running time of Arratlist.get() and Vector.get()
        */
        long startAL = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            arrayList.get(i);
        }
        long endAL = System.nanoTime();
        long durAL = endAL - startAL;
        System.out.println("ArrayList get: " + durAL);

        long startV = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            v.get(i);
        }
        long endV = System.nanoTime();
        long durV = endV - startV;
        System.out.println("Vector get: " + durV);

        long startA = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Array.get(array, i);
        }
        long endA = System.nanoTime();
        long durA =  endA - startA;
        System.out.println("Array get: " + durA);
        /**
        *Test the running time of Arraylist.remove() and Vector.remove()
        */
        long startRAL = System.nanoTime();
        for(int i = 9999; i >= 0; i--){
            arrayList.remove(i);
        }
        long endRAL = System.nanoTime();
        long durationRAL = endRAL - startRAL;
        System.out.println("Arraylist remove: " + durationRAL);

        long startTimeRV = System.nanoTime();
        for(int i = 9999; i >= 0; i--){
            v.remove(i);
        }
        long endTimeRV = System.nanoTime();
        long durationRV = endTimeRV - startTimeRV;
        System.out.println("Vector remove: " + durationRV);
    }
	
}