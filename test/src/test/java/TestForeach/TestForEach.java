package TestForEach;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/6/6 11:30
 * @Version: 1.0
 */
public class TestForEach {

    //实例化arrayList
    List<Integer> arrayList = new ArrayList<Integer>();
    //实例化linkList
    List<Integer> linkList = new LinkedList<Integer>();

    @Before
    public void before() {
        //插入10万条数据
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkList.add(i);
        }
    }

    @Test
    public void testForEach() {

    }

    @Test
    public void testForeach4() {
        int link;
        //用froeach循环linkList
        long linkForeachStartTime = System.currentTimeMillis();
        for (Integer in : linkList) {
            link = in;
        }
        long linkForeachEndTime = System.currentTimeMillis();
        System.out.println("用foreach循环linkList 10万次花费时间：" + (linkForeachEndTime - linkForeachStartTime) + "毫秒");
    }

    @Test
    public void testForeach3() {
        //用for循环linkList
        long linkForStartTime = System.currentTimeMillis();
        int link = 0;
        for (int i = 0; i < linkList.size(); i++) {
            link = linkList.get(i);
        }
        long linkForEndTime = System.currentTimeMillis();
        System.out.println("用for循环linkList 10万次花费时间：" + (linkForEndTime - linkForStartTime) + "毫秒");
    }

    @Test
    public void testForeach2() {
        int array;
        //用foreach循环arrayList
        long arrayForeachStartTime = System.currentTimeMillis();
        for (Integer in : arrayList) {
            array = in;
        }
        long arrayForeachEndTime = System.currentTimeMillis();
        System.out.println("用foreach循环arrayList 10万次花费时间：" + (arrayForeachEndTime - arrayForeachStartTime) + "毫秒");
    }

    @Test
    public void testForeach1() {
        int array = 0;
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            array = arrayList.get(i);
        }
        long arrayForEndTime = System.currentTimeMillis();
        System.out.println("用for循环arrayList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
    }

    @Test
    public void testForeach5() {
        AtomicInteger array = new AtomicInteger();
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        arrayList.stream().forEach((a) -> array.set(a));
        long arrayForEndTime = System.currentTimeMillis();
        System.out.println("用lambda循环arrayList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
    }

    @Test
    public void testForeach6() {
        AtomicInteger array = new AtomicInteger();
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        linkList.stream().forEach(a -> array.set(a));
        long arrayForEndTime = System.currentTimeMillis();
        System.out.println("用lambda循环linkList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
    }

    @Test
    public void testForeach7() {
        int array = 0;
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            array = iterator.next();
        }
        long arrayForEndTime = System.currentTimeMillis();
        System.out.println("用while循环arrayList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
    }

    @Test
    public void testForeach8() {
        int array = 0;
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        Iterator<Integer> iterator = linkList.iterator();
        while (iterator.hasNext()) {
            array = iterator.next();
        }
        long arrayForEndTime = System.currentTimeMillis();
        System.out.println("用while循环linkList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
    }
}
