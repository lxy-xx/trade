import com.safewind.methods.Entryption;

public class Test {
    @org.junit.Test
    public void test() {
        Entryption e=new Entryption();
        System.out.println(e.md5password("1528620113640e10adc3949ba59abbe56e057f20f883e"));
    }
}
