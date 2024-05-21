package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
//以CommunityApplication为配置类
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {
	//申请Spring容器
	private  ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		//从容器中根据类型获取bean
		AlphaDao alphadao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphadao.select());
		//从容器中根据name获取bean
		alphadao = applicationContext.getBean("alphaHi", AlphaDao.class);
		System.out.println(alphadao.select());
	}
	@Test
	//容器中bean是单例
	public void testBeanManagement() {
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	//容器将AlphaDao注入给这个属性
	@Autowired
	//优先使用name为“”的类型
	@Qualifier("alphaHi")
	private AlphaDao alphaDao;

	@Test
	public  void testDI() {
		System.out.println(alphaDao.select());
	}
}


