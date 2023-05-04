import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String[] strArr = { "aaa", "ddd", "bbb", "ccc" };
        List<String> list = Arrays.asList(strArr);
        list.forEach(System.out::println);
        Arrays.sort(strArr);
        for (String s : strArr) {
            System.out.println(s);
        }

        System.out.println("=============================");
        // List
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
        // 정렬된 형태의 출력
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = Arrays.stream(strArr);

        // Iterator : next, hasNext
        System.out.println("=============================");

        Iterator<String> iter = list.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        // while(iter.hasNext() != -1)
        iter = list.iterator();
        System.out.println(iter.next());

        System.out.println("===========stream 한 번 더 선언하여 정렬된 내부 반복작업 처리=============");
        stream1 = list.stream();
        // stream1.sorted().forEach(System.out::println);
        stream1.sorted().forEach((s) -> System.out.println(s));
        // $("p").css("color", "red")

        // IntStream intStream = IntStream.rangeClosed(0, 0);

        System.out.println("===========================================================");
        IntStream intStream = new Random().ints(1, 10).limit(20);
        intStream.forEach(i -> System.out.println(i));

        Stream<String> stream3 = Stream.of("123", "가나다", "12");
        System.out.println("=============================");
        stream3.forEach(s -> System.out.println(s));

        List<String> list2 = new ArrayList<>();
        list2.add("김길동");
        list2.add("박길동");
        list2.add("박현빈");
        list2.add("홍길동");
        list2.add("김삼순");
        list2.add("김유신");

        // 1. 김씨 성을 가진 인물 출력
        // System.out.println(list2.stream().filter(s ->
        // s.contains("김")).collect(Collectors.toList())); 타당하지 않은 방법
        list2.stream().filter(s -> s.startsWith("김")).forEach(System.out::println);

        // 2. 이름이 길동인 인물 출력
        // System.out.println(list2.stream().filter(s ->
        // s.contains("길동")).collect(Collectors.toList())); 타당하지 않은 방법

        list2.stream().filter(new Predicate<String>() {
            public boolean test(String s) {
                return s.endsWith("길동");
            };
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        File file = new File("C:\\Users\\TJ\\Desktop");

        // 해당 바탕화면 폴더의 디렉토리가 아닌 파일만 골라서 파일 이름(map) 출력 >> 해당 파일명의 길이를 출력하는 것으로 변경
        Arrays.stream(file.listFiles()).filter(f -> f.isFile())
                .map(f -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("size", f.length());
                    map.put("name", f.getName());
                    map.put("length", f.getName().length());
                    return map;
                })
                // .map(f ->
                // f.getName())
                // .map(s -> (Integer) s.length())
                .forEach(System.out::println);

    }
}
