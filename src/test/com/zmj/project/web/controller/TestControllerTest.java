package com.zmj.project.web.controller;
import base.BaseApiTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * java类简单作用描述
 *
 * @ClassName: ${TYPE_NAME}
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/29 10:34
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/29 10:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestControllerTest extends BaseApiTest {

    private MockMvc mockMvc;
    @Autowired
    private TestController testController;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void testValidate()  {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testValidate"))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mvcResult);

    }

    @Test
    public void testValidate2() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testValidate2"))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mvcResult);
    }

    @Test
    public void testValidate3() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testValidate3"))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mvcResult);
    }
}