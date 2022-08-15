package wx.th.zlo.javabaseboot.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallTest {
	
	
	public static void main(String[] args) {
		
		ExecutorService threadPool = new ThreadPoolExecutor(1, 3, 0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		Future<String> future =threadPool.submit(new CallTask());
	
		try {
			System.out.println(future.get(1,TimeUnit.SECONDS));// ���û�ý���ĳ�ʱʱ��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("ʱ�䳬ʱ");
			
		}finally{  
            System.out.println("�̷߳���رա�");  
            threadPool.shutdown();  
        }  
	}

}


class CallTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "�������";
	}
	
}
