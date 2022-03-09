package com.shanjiancaofu.designmode.设计模式相关.抽象工厂模式;

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){



      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}
