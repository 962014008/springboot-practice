package cn.stackbox.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.Callable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	@Autowired
	WebApplicationContext webApplicationContext;

	MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  //初始化MockMvc对象
	}

	@Test
	public void contextLoads() throws Exception {

		Integer callable1 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// get请求
				// 1. 测试Ehcache缓存cache1 (使用KeyGenerator)
				// 问题：缓存生效的时候，ehcache里面存储的数据是怎么样的？
				MockHttpServletRequestBuilder get1 = MockMvcRequestBuilders.get("/cache/cache1");
				String result1 = mockMvc.perform(get1).andReturn().getResponse().getContentAsString();
				System.out.println("get /cache/cache1 请求结果: " + result1);

				// 2. 测试Ehcache缓存cache2 (使用自定义Key)
				// 问题：缓存生效的时候，ehcache里面存储的数据是怎么样的？
				MockHttpServletRequestBuilder get2 = MockMvcRequestBuilders.get("/cache/cache2");
				String result2 = mockMvc.perform(get2).andReturn().getResponse().getContentAsString();
				System.out.println("get /cache/cache2 请求结果: " + result2);

				return 1;
			}}.call();

		/**
		Integer callable2 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// get请求
				// 3. 测试Redis缓存cache3
				// 问题：缓存生效的时候，redis里面存储的数据是怎么样的？
				MockHttpServletRequestBuilder get3 = MockMvcRequestBuilders.get("/cache/cache3");
				String result3 = mockMvc.perform(get3).andReturn().getResponse().getContentAsString();
				System.out.println("get /cache/cache3 请求结果: " + result3);

				// 4. 刷新缓存
				// 问题：刷新缓存后，再次调用缓存，返回什么数据？
				MockHttpServletRequestBuilder get4 = MockMvcRequestBuilders.get("/cache/refresh");
				String result4 = mockMvc.perform(get4).andReturn().getResponse().getContentAsString();
				System.out.println("get /cache/refresh 请求结果: " + result4);
				
				return 1;
			}}.call();
**/
	}

}
