import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class Http {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    public static String Request() throws IOException {
        Http client = new Http();
        String result;
        try {
            result = client.sendGet();
        }
        finally {
            client.close();
        }
        return result;
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private String sendGet() throws IOException {
        HttpGet request = new HttpGet("http://138.197.181.131:8080/restaurants");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
            return result;
        }
    }
}