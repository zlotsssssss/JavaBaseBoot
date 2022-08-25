package wx.th.zlo.javabaseboot.fghij.f.functionInterface;

public class Something {
 
    // constructor methods
    Something() {}
 
    Something(String something) {
	System.out.println(something);
    }
 
    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
    
    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }
    
    void endWith() {}
}