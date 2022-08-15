package wx.th.zlo.javabaseboot.FunctionalInterface;

@FunctionalInterface
public interface IConvert<F, T> {
    T convert(F form);
}