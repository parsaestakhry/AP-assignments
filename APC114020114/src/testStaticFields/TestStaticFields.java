package testStaticFields;

public class TestStaticFields {
    public static void main(String[] args) {
//         ValueStatic.b = 50;
//        System.out.println(ValueStatic.b);
//       
        ValueStatic v = null;
        
        System.out.println(v.b);
        v.b = 40;
        v = new ValueStatic();
        System.out.println(v.b);
        ValueStatic u = new ValueStatic();
        System.out.println(u.b);
    }
    
}

class ValueStatic{
    int a;
    static int b = 13;
}
