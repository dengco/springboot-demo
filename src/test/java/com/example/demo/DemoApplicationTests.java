package com.example.demo;


import io.swagger.models.auth.In;
import junit.framework.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    //@Test
    public void contextLoads() {
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 3, 9, 7));
        System.out.println(findTwo3(list,13));

    }

    /**

     * 使用辅助空间(使用哈希表，时间复杂度是O(n),空间复杂度：O(n),n是数组大小)

     * @param nums

     * @param target

     * @return 没有找到的话数组中数值就是{-1,-1}，否则找到，其实我想返回null的，但是觉得返回null不礼貌，因为null有毒

     */

    public static boolean findTwo3(List<Integer> list, int sum){

        // 结果数组

        boolean result=false;

        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();

        for(int i=0;i<list.size();i++){

            map.put(list.get(i), i);

        }


        for(int i=0;i<list.size();i++){
            int two=sum-list.get(i);
            if(map.containsKey(two)&&sum!=2*two){

                return true;
            }
        }
        // 没有找到

        return result;

    }


}

