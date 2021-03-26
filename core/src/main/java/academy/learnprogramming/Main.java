package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number Game");

//        ***** Create Context:
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
//        Get Beans:
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);
        Game game
                = context.getBean(Game.class);

//        ---> MAIN APP:
        int number = numberGenerator.next();
        log.info("number = {}", number);
        game.reset();

//        END MAIN APP <---

//        ***** Close Context:
        context.close();
    }
}
