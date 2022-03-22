package com.shanjiancaofu.designmode.设计模式相关.抽象工厂模式;

public class Green implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}
