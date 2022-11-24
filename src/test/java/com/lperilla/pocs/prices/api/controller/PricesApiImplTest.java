package com.lperilla.pocs.prices.api.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lperilla.pocs.prices.api.PricesApiApplication;

@SpringBootTest(classes = PricesApiApplication.class)
class PricesApiImplTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    final void testFindPrice_test1() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/brands/{brandId}/products/{productId}/prices", 1, 35455)
                .param("applicationDate", "2020-06-14T10:00:00Z")
                .accept(MediaType.APPLICATION_JSON));
        result.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00+02:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59+01:00"))
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.price").value(35.50))
        .andExpect(jsonPath("$.currency").value("EUR"));
    }

    /**
     * Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    final void testFindPrice_test2() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/brands/{brandId}/products/{productId}/prices", 1, 35455)
                .param("applicationDate", "2020-06-14T16:00:00Z")
                .accept(MediaType.APPLICATION_JSON));
        result.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00+02:00"))
        .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00+02:00"))
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.price").value(25.45))
        .andExpect(jsonPath("$.currency").value("EUR"));
    }
    
    /**
     * Petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    final void testFindPrice_test3() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/brands/{brandId}/products/{productId}/prices", 1, 35455)
                .param("applicationDate", "2020-06-14T21:00:00Z")
                .accept(MediaType.APPLICATION_JSON));
        result.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00+02:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59+01:00"))
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.price").value(35.50))
        .andExpect(jsonPath("$.currency").value("EUR"));
    }
    
    /**
     * Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    final void testFindPrice_test4() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/brands/{brandId}/products/{productId}/prices", 1, 35455)
                .param("applicationDate", "2020-06-15T10:00:00+02:00")
                .accept(MediaType.APPLICATION_JSON));
        result.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00+02:00"))
        .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00+02:00"))
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.price").value(30.50))
        .andExpect(jsonPath("$.currency").value("EUR"));
    }

    /**
     * Petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    final void testFindPrice_test5() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/brands/{brandId}/products/{productId}/prices", 1, 35455)
                .param("applicationDate", "2020-06-16T21:00:00Z")
                .accept(MediaType.APPLICATION_JSON));
        result.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00+02:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59+01:00"))
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.price").value(38.95))
        .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    final void testPriceController() {
        assertNotNull(webApplicationContext.getBean(PricesApi.class));
    }


}
