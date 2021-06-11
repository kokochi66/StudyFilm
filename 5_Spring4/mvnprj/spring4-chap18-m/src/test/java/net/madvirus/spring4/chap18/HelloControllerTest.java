package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-mvc.xml")
@WebAppConfiguration
public class HelloControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "bkchoi"))
				.andExpect(status().isOk())
				.andExpect(view().name("hello"))
				.andExpect(header().doesNotExist("UAC"))
				.andExpect(model().attributeExists("greeting"))
				.andExpect(model().hasNoErrors());
	}

	@Test
	public void testHelloJson() throws Exception {
		mockMvc.perform(post("/hello.json")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"최범균\"}")
				)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(cookie().doesNotExist("UAC"))
				.andExpect(jsonPath("$.greeting", equalTo("안녕하세요, 최범균")));
	}
}
