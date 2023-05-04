import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Subway {
  public static void main(String[] args) throws IOException {
    // csv -> List<Map<String, Object>>
    // BufferedReader isr =

    // FileReader fr = new
    // FileReader("C:\\Users\\TJ\\Desktop\\stream\\Stream\\src\\CARD_SUBWAY_MONTH_202303.csv");

    List<String> inputListStr = new ArrayList<>();

    // fileInputStream의 charset은 VSC에서는 지원하지 않기 때문에 InputStreamReader 기준으로 charset을
    // 잡는다.
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream("C:\\Users\\TJ\\Desktop\\stream\\Stream\\src\\CARD_SUBWAY_MONTH_202303.csv"), "utf-8"));
    String str = null;
    while ((str = br.readLine()) != null) {
      inputListStr.add(br.readLine());
    }
    // System.out.println(inputListStr);
    // String lines = br.readLine();

    // System.out.println(lines);
    br.close();

    // inputList<String.stream().map(String >> Map) : List<Map<String, Object>>
    // 경계
    // 집계함수 (max, min, sum, avg, count)
    for (int i = 0; i < inputListStr.size(); i++) {
      Object[] obj = inputListStr.get(i).split(",");
      System.out.println(Arrays.toString(obj));
      // System.out.println(obj.to);
      // obj[0]

    }
    // inputListStr.stream().map(s -> {
    // Map<String, Object> map = new HashMap<>();
    // map.put(s, str)
    // return null;
    // })
    // Map<String, Object> map = new HashMap<>();
    // // Object[] obj = inputListStr.
    // inputListStr.stream().forEach(System.out::println);
    // inputListStr.stream().map(s -> map.put(s. , s))

    // 날짜별(10일단위)로 출력
    // inputListStr.stream().collect(
    // Collectors.groupingBy(
    // // 그룹 대상
    // inputListStr.,
    // // 형태(타입)
    // null,
    // null));
  }
}
