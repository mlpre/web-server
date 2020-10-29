package util;

public class BaseUtil {

    public static String getBeanName(String bean, String name) {
        char[] chars = bean.substring(bean.lastIndexOf(".") + 1).toCharArray();
        chars[0] += 32;
        return String.valueOf(chars) + name;
    }

}
