package com.shanjiancaofu.designmode.设计模式相关._15command;

import java.util.ArrayList;
import java.util.List;

public class Macro {
    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }
}
