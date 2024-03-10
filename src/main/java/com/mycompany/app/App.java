package com.mycompany.app;
import java.util.ArrayList;
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
    public static String meaningfulOperation(ArrayList<Integer> array,int [] arrInt,int i,String [] strArr){ // set of stringten arraylistte bulunan intleri index kabul edip o stringleri alıp concatanate eder sonra normal arraydekileri index kabul edip ekler en sonda tekli verilen indexteki elemanıda ekleyip dönürür
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
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String i1 = req.queryParams("input1");
          String i2 = req.queryParams("input2");
          String i3 = req.queryParams("input3");
          String i4 = req.queryParams("input4");
          java.util.Scanner sc1 = new java.util.Scanner(i1);
          java.util.Scanner sc2 = new java.util.Scanner(i2);
          java.util.Scanner sc3 = new java.util.Scanner(i3);
          java.util.Scanner sc4 = new java.util.Scanner(i4);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          int[] intArr = new int[50];  
          int a = 0;        
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            intArr[a] = value;
            a++;
          }
          int inputInteger;
          while (sc3.hasNext())
          {
            inputInteger = Integer.parseInt(sc1.next().replaceAll("\\s",""));
          }
          String[] strArr = new String[50];
          a = 0;
          while (sc4.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            strArr[a] = value;
          }

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


