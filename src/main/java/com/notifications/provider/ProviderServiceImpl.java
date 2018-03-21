package com.notifications.provider;

import com.notifications.provider.dto.FaxResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Service
public class ProviderServiceImpl implements IProviderService {

    private static final String url = "http://localhost:9100/tinsa/fax";

    private final RestTemplate restTemplate;

    public ProviderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FaxResponse sendNotification(String phoneNumber, String msg) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url)
                // Add query parameter
                .queryParam("phone", phoneNumber)
                .queryParam("message", msg);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("headers", headers);

        return restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, entity, FaxResponse.class).getBody();
    }
}
