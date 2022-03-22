package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式.解决线程安全问题;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtrinsicState {
    //考试科目
    private String subject;
    //考试地点
    private String location;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExtrinsicState) {
            ExtrinsicState state = (ExtrinsicState) obj;
            return state.getLocation().equals(location) && state.getSubject().equals(subject);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return subject.hashCode() + location.hashCode();
    }
}
