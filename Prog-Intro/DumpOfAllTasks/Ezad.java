import java.util.*;

public class Ezad {
    public List<Integer> encode(String data) {
        List<Integer> result = new ArrayList<>();


        int idleCode = 256;
        HashMap<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dic.put((char) i + "", i);
        }

        String prefix = "";
        String suffix = "";
        for (char c : data.toCharArray()) {
            suffix = prefix + c;
            if (dic.containsKey(suffix)) {
                prefix = suffix;
            } else {
                dic.put(suffix, idleCode++);
                result.add(dic.get(prefix));

                prefix = "" + c;
            }
        }

        if (!prefix.equals("")) {
            result.add(dic.get(prefix));

        }
        return result;
    }
}