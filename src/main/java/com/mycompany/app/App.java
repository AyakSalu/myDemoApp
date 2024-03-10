package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String meaningfulOperation(ArrayList<Integer> array,Integer [] arrInt,int i,String [] strArr){ // set of stringten arraylistte bulunan intleri index kabul edip o stringleri alıp concatanate eder sonra normal arraydekileri index kabul edip ekler en sonda tekli verilen indexteki elemanıda ekleyip dönürür
      System.out.println("array1= "+array+" array2 = "+Arrays.toString(arrInt)+" int değeri = "+i+" string = "+ Arrays.toString(strArr));  
      if(strArr.length < 1) return "";
        String cevap = "";
        if(array!= null){
          for(int index : array){
            if(index >= strArr.length && index >= 0) continue;
            else{
              cevap += strArr[index];
            }
          }
        }
        if(arrInt != null){
          for(int index : arrInt){
            if(index >= strArr.length && index >= 0) continue;
            else{
              cevap += strArr[index];
            }
          }
        }
        if(i < strArr.length && i >= 0) cevap += strArr[i];

        return cevap;
    }
    
    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
    
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
      }



      public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          System.out.println("input1: "+req.queryParams("input1"));
          System.out.println("input2: "+req.queryParams("input2"));
          System.out.println("input3: "+req.queryParams("input3"));
          System.out.println("input4: "+req.queryParams("input4"));

          String i1 = req.queryParams("input1");
          String i2 = req.queryParams("input2");
          String i3 = req.queryParams("input3");
          String i4 = req.queryParams("input4");
          System.out.println("stringler"+i1 + "\n"+i2 + "\n"+i3 + "\n"+i4 + "\n");  
          java.util.Scanner sc1 = new java.util.Scanner(i1);
          java.util.Scanner sc2 = new java.util.Scanner(i2);
          java.util.Scanner sc3 = new java.util.Scanner(i3);
          java.util.Scanner sc4 = new java.util.Scanner(i4);
          sc1.useDelimiter("[;\r\n]+");
          sc2.useDelimiter("[;\r\n]+");
          sc3.useDelimiter("[;\r\n]+");
          sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNextInt())
          {
            int value = sc1.nextInt();
            inputList.add(value);
          }
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>(); 
  
          while (sc2.hasNextInt())
          {
            int value = sc2.nextInt();
            inputList2.add(value);
          }
          Integer[] intArr = new Integer[inputList2.size()];
          intArr = inputList2.toArray(intArr);
          int inputInteger = sc3.nextInt();
          java.util.ArrayList<String> strArrList = new java.util.ArrayList<>();
          
          while (sc4.hasNext())
          {
            String value = sc4.next().replaceAll("\\s","");
            strArrList.add(value);
          }
          String[] strArr = new String[strArrList.size()];
          strArr = inputList2.toArray(strArr);
          String result = App.meaningfulOperation(inputList,intArr,inputInteger,strArr);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
      }
  
}


