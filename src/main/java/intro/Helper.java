package intro;

import java.util.concurrent.TimeUnit;

public class Helper {

        // будет замораживать код на несколько милисекунд
        public static void pause(Integer milliseconds) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

