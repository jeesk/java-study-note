package com.shanjiancaofu.juc.thread.chapter08;


import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {
    /**
     * ����4�����ϣ�������֮��ִ�е�ǰ���run����
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * ����ֻ��4��sheet������ֻ����4���߳�
     */
    private Executor executor = Executors.newFixedThreadPool(4);
    /**
     * ����ÿ��sheet��������������
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new
            ConcurrentHashMap<String, Integer>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                // ���㵱ǰsheet���������ݣ��������ʡ��
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                // ����������ɣ�����һ������
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // ����ÿ��sheet������Ľ��
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        // ��������
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}


