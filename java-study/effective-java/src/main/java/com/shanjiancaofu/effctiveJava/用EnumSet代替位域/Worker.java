package com.shanjiancaofu.effctiveJava.用EnumSet代替位域;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

class Worker {
    String name;
    Set<Day> availableDays;

    public Worker(String name, Set<Day> availableDays) {
        this.name = name;
        this.availableDays = availableDays;
    }

    public String getName() {
        return name;
    }

    public Set<Day> getAvailableDays() {
        return availableDays;
    }

    public static void main(String[] args) {

        //
        Worker[] workers = new Worker[]{
                new Worker("张三", EnumSet.of(
                        Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
                new Worker("李四", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
                new Worker("王五", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY)),
        };
        // 所有的工作日
        Set<Day> days = EnumSet.allOf(Day.class);
        // 移除所有工人工作日， 那么剩下的就是， 一个工人都没有来的工人
        System.out.println(days);
        for (Worker w : workers) {
            days.removeAll(w.getAvailableDays());
        }
        System.out.println(days);

        // 一个人都没有， 求那些于会有一个人来， 就是说求有人来的星期
        Set<Day> days1 = EnumSet.noneOf(Day.class);
        for (Worker w : workers) {
            days1.addAll(w.getAvailableDays());
        }
        System.out.println(days1);


        // 求那些天，所有的人都会来。 就是求交集
        Set<Day> day2 = EnumSet.allOf(Day.class);
        for (Worker w : workers) {
            day2.retainAll(w.getAvailableDays());
        }
        System.out.println(day2);

        // 那些人，会在周一，周二的时候来。 求，和周一，周2的交集
        Set<Worker> availableWorkers = new HashSet<Worker>();
        for (Worker w : workers) {
            if (w.getAvailableDays().containsAll(
                    EnumSet.of(Day.MONDAY, Day.TUESDAY))) {
                availableWorkers.add(w);
            }
        }
        for (Worker w : availableWorkers) {
            System.out.println(w.getName());
        }
    }


}
