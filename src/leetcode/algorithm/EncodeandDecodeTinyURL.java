package leetcode.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EncodeandDecodeTinyURL {
    private String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private Map<String, String> tinys = new HashMap<String, String>();

        private String uniqueString(int len) {
            String unique = "";
            Random r = new Random();
            for (int i = 0; i <= len; i++) {
                int pos = r.nextInt(chars.length());
                unique += chars.charAt(pos);
            }
            return unique;
        }
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String coded = uniqueString(6);
            tinys.put(coded, longUrl);
            return coded;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (tinys.containsKey(shortUrl)) {
                return tinys.get(shortUrl);
            }
            return null;
    }
}
