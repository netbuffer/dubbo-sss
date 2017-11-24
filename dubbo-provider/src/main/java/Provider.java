import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;

import java.io.IOException;

public class Provider {

    private static final Logger LOGGER= LoggerFactory.getLogger(Provider.class);

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        LOGGER.info("display name:{},application name:{}\n", context.getDisplayName(), context.getApplicationName());
//        context.start();
        LOGGER.info("服务启动完成:{}\n", new DateTime(context.getStartupDate()).toString(DATE_PATTERN));
        System.in.read();
    }
}