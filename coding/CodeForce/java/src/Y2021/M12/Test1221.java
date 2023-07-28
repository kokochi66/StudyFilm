package src.Y2021.M12;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Test1221 {
    private final static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
/*        String address = "https://jsonplaceholder.typicode.com/posts/1";
        String[] headers = {};
        String body = "";

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1).build();
        String res = client.sendAsync(
                HttpRequest.newBuilder(
                        new URI(address)).GET().build(),
                        HttpResponse.BodyHandlers.ofString()
        ).thenApply(HttpResponse::body).get();
        System.out.println(res);*/

//        String str = "yaho";
//        Object obj = str;
//        List<String> strList = new ArrayList<>();
////        List<Object> objList = strList;
//
//        App<String> app = new AppChild<>(" ","bbb");
//        System.out.println(app.getA().isBlank());
//        System.out.println(app.getA().isEmpty());

/*        String str = "yaho";
        Integer i = 123;
        Integer i2 = 22 + i;

        list.add(1);
        list.add(2);
        list.add(3);
        st(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.gc();*/

//        App<Integer> app = new AppChild<>(1,2);
//        System.out.println(app.getA());
//        st(app);

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("d",1);
        map.put("c",2);
        map.put("b",3);
        map.put("a",4);
        System.out.println(map.higherKey("c"));
    }

    static void printApp(App<?> app) {
        System.out.println(app.getA());
    }

    static void st(App<Integer> app) {
        app.setA(3);
    }


    static abstract class App<V> {
        V a;

        public App(V a) {
            this.a = a;
        }

        public V getA() {
            return a;
        }

        public void setA(V a) {
            this.a = a;
        }
    }

    static class AppChild<V> extends App<V> {
        private static final long serialVersionUID = 362498820763181265L;

        V b;

        public AppChild(V a, V b) {
            super(a);
            this.b = b;
        }

        public V getB() {
            return b;
        }

        public void setB(V b) {
            this.b = b;
        }
    }


}
