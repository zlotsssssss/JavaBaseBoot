package wx.th.zlo.javabaseboot.aabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ClassName: Test
 * Description: TODO
 * Author: zlo
 * Date: 2022/9/27 16:33
 * Version: 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        System.out.println(sdf.format(nowTime.getTime()));
    }
}
