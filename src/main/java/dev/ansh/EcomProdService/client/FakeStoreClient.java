package dev.ansh.EcomProdService.client;

import dev.ansh.EcomProdService.dto.FakeStoreCartResponseDTO;
import dev.ansh.EcomProdService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseURL;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.card.for.user.path}")
    private String fakeStoreAPICardForUserPath;

    public List<FakeStoreProductResponseDTO> getAllProducts()
    {
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
                return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductbyId(int id)
    {
        String fakeStoreGetProductURL = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath).concat("/"+id);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(fakeStoreGetProductURL, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
    public List<FakeStoreCartResponseDTO> GetCardByUserId(int userId)
    {
        if(userId<1)
            return null;
        String fakeStoreGetCartForUser = fakeStoreAPIBaseURL.concat(fakeStoreAPICardForUserPath).concat(String.valueOf(userId));
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }

}
