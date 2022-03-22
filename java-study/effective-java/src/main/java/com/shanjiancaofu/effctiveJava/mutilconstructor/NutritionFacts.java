package com.shanjiancaofu.effctiveJava.mutilconstructor;

public class NutritionFacts {

    // 使用多参数构造器更方便, 如果很多参数的时候, 不利于阅读.
    // 可以使用JavaBeans的模式来


    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;


    public NutritionFacts(int servingSize) {
        this(servingSize, 0, 0, 0, 0);

    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0, 0);

    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);

    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;

    }

}
