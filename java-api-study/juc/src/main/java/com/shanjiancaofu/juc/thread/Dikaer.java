package com.shanjiancaofu.juc.thread;



import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 宋奇福 <meetsong@foxmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/11 0:29
 */
public class Dikaer {


    public void test(){

        List<String> names = new ArrayList<>();
        names.add("xiaoming");
        names.add("xiaohuang");
        List<String> ages = new ArrayList<>();
        ages.add("99");
        ages.add("22");

        List<String> heights = new ArrayList<>();
        heights.add("100");
        heights.add("1000");

        List<List<String>> dataList = new ArrayList<>();
        dataList.add(names);
        dataList.add(ages);
       dataList.add(heights);
        // 最后的结果集合
        List<List<String>> resultDate = new ArrayList<>();
        // 临时的集合

        recursion(resultDate, dataList, 0, new ArrayList<String>());

       resultDate.forEach(a->{
           System.out.println(a);

        });



    }


    public  void recursion(List<List<String>> resultList, List<List<String>> recursionList, int layer, List<String> dataList) {

        // 如果不是最后一层
        if ( (recursionList.size() - 1 )> layer) {
            // 遍历
            recursionList.get(layer).forEach(data -> {
                // 把上次的所有字符串添加到一个集合里面
                List<String> temp = new ArrayList<>();
                temp.addAll(dataList);
                temp.add(data);
                // 继续遍历下一层
                recursion(resultList, recursionList, layer + 1, temp);
            });

        } else {

            // 遍历 最后一层的所有元素,并且添加到集合里面去
            recursionList.get(layer).forEach(data -> {
                // 把上次的所有字符串添加到一个集合里面
                List<String> temp = new ArrayList<>();
                temp.addAll(dataList);
                temp.add(data);
                // 继续遍历下一层
                resultList.add(temp);
            });

        }




    }
}
