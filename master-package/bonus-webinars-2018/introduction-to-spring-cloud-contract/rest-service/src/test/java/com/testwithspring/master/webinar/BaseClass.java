package com.testwithspring.master.webinar;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * This base class configures the system under test.
 */
public abstract class BaseClass {

    /**
     * This setup method ensures that our REST API fulfills
     * our contract.
     */
    @Before
    public void setup() {
        TaskService service = mock(TaskService.class);

        RestAssuredMockMvc.standaloneSetup(new TaskController(service));
        given(service.findById(1L)).willReturn(new Task(1L, "Write our first contract"));
    }
}
