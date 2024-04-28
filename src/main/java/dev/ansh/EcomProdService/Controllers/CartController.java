package dev.ansh.EcomProdService.Controllers;

import dev.ansh.EcomProdService.client.FakeStoreClient;
import dev.ansh.EcomProdService.dto.FakeStoreCartResponseDTO;
import dev.ansh.EcomProdService.exception.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity GetCartForUser(@PathVariable("userId") int userId) {
        List<FakeStoreCartResponseDTO> cartResponse=fakeStoreClient.GetCardByUserId(userId);
        if(cartResponse==null)
        {
            throw new CartNotFoundException("cart not found for user id "+userId);
        }
        return ResponseEntity.ok().body(cartResponse);

    }
}
