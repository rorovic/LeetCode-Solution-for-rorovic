package main.java.solution;


import java.io.UnsupportedEncodingException;

/**
 * Created by dujinyuan on 17/5/8.
 */
public class Codec535 {
    private final static String ENCODE = "GBK";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String result = "";
        if(longUrl == null){
            return "";
        }
        try{
            result = java.net.URLEncoder.encode(longUrl,ENCODE);
        }catch (UnsupportedEncodingException s){
            s.printStackTrace();
        }
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String result = "";
        if (null == shortUrl) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(shortUrl, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
