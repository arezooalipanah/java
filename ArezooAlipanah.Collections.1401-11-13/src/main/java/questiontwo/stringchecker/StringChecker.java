package questiontwo.stringchecker;

import java.util.Hashtable;
import java.util.Map;

public class StringChecker {
    public static boolean checkCharsBeingUnique(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception();
        }
        Map<Integer, Boolean> hashtable = new Hashtable<>();
        for (char ch : str.toCharArray()) {
            if (hashtable.containsKey((int)ch)) {
                return false;
            }
            hashtable.put((int) ch, true);
        }
        return true;
    }
}
