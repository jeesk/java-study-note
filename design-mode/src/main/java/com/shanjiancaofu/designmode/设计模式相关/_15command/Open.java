package com.shanjiancaofu.designmode.设计模式相关._15command;

public class Open implements Action {
    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
