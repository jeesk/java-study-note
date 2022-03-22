package com.shanjiancaofu.juc.thread;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// 集合并发的相关问题:
// 使用增强for循环(底层是迭代器, 无论是还是修改都会造成并发异常)
// 使用普通的for循环,删除会造成遍历的索引越界问题,但是增加却不会造成任何问题
// 使用迭代的的自带方法不会造成任何修改并发异常
// java 8 的迭代方式是安全的

//  相反的如果使用CopyOnWriteArrayList 集合, 那么使用普通的for循环操作不会有任何问题. 写时拷贝
public class ListDemo {

	List<String> list;

	@Before
	public void init() {
		//  list = new ArrayList<String>();
		list = new CopyOnWriteArrayList<String>();
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");

	}


	// 增强for移除元素"二"
	// 普通的for循环遍历使用集合的删除和增加都会并发异常
	@Test
	public void test() {
		for (Object o : list) {
			if ("二".equals(o.toString())) {
				list.remove(o);
				//  list.add(0 + "1");
			}
			System.out.println(o);
		}
		System.out.println(list);
	}

	//使用普通for循环遍历，虽然不会并发异常，但是由于索引和size大小在移除的时候就会发生变化，所以容易数组越界,增加不会造成异常
	@Test
	public void useNormalForMove1() {
		for (int i = 0; i < list.size(); i++) {
			if ("四".equals(list.get(i))) {
				list.remove(i);
				// list.add(i + "1");
			}
			System.out.println(list.get(i));
		}
	}

	@Test // 使用Iterator去操作集合，才能正常删除和遍历元素
	public void useIteratorMove1() {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next();
			if (str.equals("二") || str.equals("四")) {
				it.remove();
			}
			System.out.println(it.next());
		}
	}

	// 使用java8的方式来操作无论是删除还是增加都不会有任何的异常
	@Test
	public void java8ForEach() {

		list.forEach(l -> {
			if ("四".equals(l)) {
				list.remove(l);
				//  list.add(l + "1");
			}
			System.out.println(l);

		});

	}


}
