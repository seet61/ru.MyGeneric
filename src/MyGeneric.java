import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * пример generic
 * Created by dmitry.arefyev on 26.11.2016.
 */

class Box implements Comparable<Box> {
    int a, b;

    public Box(int a, int b){
        this.a=a;
        this.b=b;
    }

    @Override
    public int compareTo(Box o) {
        return this.a*this.b - o.a*o.b;
    }

    @Override
    public String toString() {
        return "a=" + this.a + " b=" + this.b;
    }
}

public class MyGeneric {
    public static<T extends Comparable> T max2(T a, T b) {
        T max = a;
        if (b.compareTo(max)>0)
            max = b;
        return max;
    }

    public static void main(String[] args) {
        //хорошая манера писать тип переменных элемента
        List<Integer> list = new ArrayList<>();
        //Преобразует и упакует
        for (int i=0; i<10; i++)
            list.add(i);

        //Старый пример
        /*Vector<String> vec = new Vector<>();*/

        System.out.println(max2(6, 11));
        System.out.println(max2("abce", "abcd"));

        System.out.println(max2(new Box(6,1), new Box(1,2)));

        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.printf("%d ", it.next());
    }
}