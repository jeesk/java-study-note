package com.shanjiancaofu.effctiveJava.重试机制.SpringRetry; /**
 * package com.example.demo.study.effctiveJava.重试机制.SpringRetry;
 * <p>
 * <p>
 * public class SpringRetry {
 * public static void main(String[] args) {
 * final String params = "传入参数,可为任意类型，final修饰即可";
 * // 重试机制
 * 重试机制.RetryTemplate oRetryTemplate = new 重试机制.RetryTemplate();
 * SimpleRetryPolicy oRetryPolicy = new SimpleRetryPolicy();
 * oRetryPolicy.setMaxAttempts(5);// 重试5次
 * oRetryTemplate.setRetryPolicy(oRetryPolicy);
 * <p>
 * try {
 * // obj为doWithRetry的返回结果，可以为任意类型
 * Object obj = oRetryTemplate.execute(new RetryCallback<Object, Exception>() {
 *
 * @Override public Object doWithRetry(RetryContext context) throws Exception {// 开始重试
 * System.out.println(params);
 * testRedo();
 * return "此处可返回操作结果";
 * }
 * }, new RecoveryCallback<Object>() {
 * @Override public Object recover(RetryContext context) throws Exception { // 重试多次后都失败了
 * return null;
 * }
 * });
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * <p>
 * private static void testRedo() {
 * System.out.println("执行Redo代码");
 * throw new RuntimeException();
 * }
 * }
 */
