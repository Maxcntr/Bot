import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class SimpleBot {

    final String[] COMON_PHAN = {
            "Хорошо сегодня ",
            "Хорошо завтра ",
            "Хорошо вчера ",
            "Хорошо когда нибудь будет",
    };
    final String[] ELET_CADET = {
            "Говори так",
            "Говори не так",
            "Говори кому говорю говори",
            "Говори молча",
    };

    final Map<String, String> PATERNS_FOR = new HashMap<String, String>() {{
        put("red","color");
        put("black", "color");
        put("elow", "color");
        put("кто\\s.*ты","who");
        put("ты\\s.*кто","who");
        put("d", "the");
    }};

    final Map<String, String> ANAVARS_BY = new HashMap<String, String>() {{

        put("color"," цвет?");
        put("who", " Я чат бот");
        put("the"," ifer");
    }};

    Pattern pattern;
    Random random;
    Date date;
    String msg;
    boolean ai;

    SimpleBot() {
        random = new Random();
        date = new Date();
    }

    public String seyInRetorn(String msg, boolean ai) {
        this.msg = msg;
        this.ai = ai;
        String say = (msg.trim().endsWith("?") ) ?
         COMON_PHAN[random.nextInt(COMON_PHAN.length)]:
        ELET_CADET[random.nextInt(ELET_CADET.length)];
        if (ai) {
            String massage;
            massage = String.join(" ", msg.toLowerCase().split("[ {,|.} ? ] + "));
            for (Map.Entry<String, String> o : PATERNS_FOR.entrySet()) {
                pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(massage).find())
                    if (o.getValue().equals("wattime")) return date.toString();
                    else return ANAVARS_BY.get(o.getValue());
            }


        }
        return say;

    }
}
