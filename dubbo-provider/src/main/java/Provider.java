import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;

import java.io.IOException;

public class Provider {
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        System.out.printf("display name:%s,application name:%s\n", context.getDisplayName(), context.getApplicationName());
//        context.start();
        System.out.printf("服务启动完成:%s\n", new DateTime(context.getStartupDate()).toString(DATE_PATTERN));
        System.in.read();
    }
}