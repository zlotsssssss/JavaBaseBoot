package wx.th.zlo.javabaseboot.fghij.i.internet;

import java.net.InetAddress;

public class InetAddressTest {
    public static void main(String[] args) throws Exception{
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        String hostAddress = byName.getHostAddress();
        String hostName = byName.getHostName();
        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}
