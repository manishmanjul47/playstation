package com.play.core.services.impl;

import com.play.core.services.UserDetailsService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.metatype.annotations.Designate;

import java.io.IOException;

@Designate(ocd = UserDetailsServiceConfiguration.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    String userDetails;
    @Override
    public String getUserDetailsFromJsonPlaceholder() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(userDetails);
        HttpResponse response = httpClient.execute(request);

        // Print response status code
        System.out.println("Response Status: " + response.getStatusLine().getStatusCode());

        // Print response body
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println("Response Body: " + responseBody);

        // Close the HttpClient
        httpClient.close();

        return responseBody;
    }

    @Activate
    protected void activate(UserDetailsServiceConfiguration config) {
        userDetails = config.userDetails();
    }
}
