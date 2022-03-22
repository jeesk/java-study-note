package com.shanjiancaofu.designmode.设计模式相关.抽象工厂模式;

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
