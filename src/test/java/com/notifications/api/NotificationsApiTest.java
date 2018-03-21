package com.notifications.api;

import com.notifications.provider.IProviderService;
import com.notifications.provider.dto.FaxResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClientException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NotificationsApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProviderService providerService;

    @Test
    public void shouldReturnAnOkResponse() throws Exception {
        String request = "{\"msg\":\"test\",\"phoneNumber\":\"911111111\",\"type\":\"FAX\"}";

        FaxResponse faxResponse = new FaxResponse();
        faxResponse.setStatus("200");
        Mockito.when(providerService.sendNotification("911111111", "test")).thenReturn(faxResponse);

        this.mockMvc.perform(post("/sendNotification")
                .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAnErrorWhenProviderFails() throws Exception {
        String request = "{\"msg\":\"test\",\"phoneNumber\":\"911111111\",\"type\":\"FAX\"}";

        Mockito.when(providerService.sendNotification("911111111", "test"))
                .thenThrow(new RestClientException("Provider error"));

        this.mockMvc.perform(post("/sendNotification")
                .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isInternalServerError());
    }

}
