import java.util.Date;
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

    Pattern pattern;
    Random random;
    Date date;
    private String msg;
    private boolean ai;

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
        return say;


    }
}
