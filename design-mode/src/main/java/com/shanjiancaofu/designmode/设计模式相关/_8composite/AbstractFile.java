package com.shanjiancaofu.designmode.设计模式相关._8composite;

import java.util.ArrayList;
import java.util.List;

interface AbstractFile {
    void solution();
}


class ImageFileImpl implements AbstractFile {
    private String name;

    public ImageFileImpl(String name) {
        this.name = name;
    }

    @Override
    public void solution() {
        System.out.println("image solution");
    }


}

class VedioFileImple implements AbstractFile {
    private String name;

    public VedioFileImple(String name) {
        this.name = name;
    }

    @Override
    public void solution() {
        System.out.println("Vedio solution： " + name);
    }
}

class Folder implements AbstractFile {

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        fileList.add(file);
    }

    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    public AbstractFile getChild(int index) {
        return fileList.get(index);
    }

    private List<AbstractFile> fileList = new ArrayList<>();

    @Override
    public void solution() {
        System.out.println("foler solution： " + name);
        fileList.forEach(x -> x.solution());
    }


}



