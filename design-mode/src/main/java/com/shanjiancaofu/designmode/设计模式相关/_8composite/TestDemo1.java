package com.shanjiancaofu.designmode.设计模式相关._8composite;

import org.junit.Test;

public class TestDemo1 {
	@Test
	public void testCompisite() {
		Folder folder = new Folder("文件夹");
		folder.add(new ImageFileImpl("图片"));
		folder.add(new VedioFileImple("视频"));


		Folder folder1 = new Folder("Folder 2");
		folder1.add(new ImageFileImpl("image 2"));
		folder.add(folder1);
		folder.solution();

		// AbstractFile is interface , Folder is 容器， 里面放着叶子节点， 同时Folder 里面也可以放容器。
		// ImageFile 则是叶子节点。   组合模式天生拥有遍历特性。  所以适合做结构遍历， 比如操作系统的资源管理器。 杀毒等。
	}
}
