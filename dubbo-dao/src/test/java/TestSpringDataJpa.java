import cn.netbuffer.dubbo.dao.IUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml"})
@ActiveProfiles(value = "test")
public class TestSpringDataJpa {

	private static Logger LOGGER = LoggerFactory.getLogger(TestSpringDataJpa.class);

	@Resource
	private IUserDao userDao;

	@Test
	public void testFindById(){
		System.out.printf("find:%s",userDao.findOne(2L));
	}
}
