package com.github.kokochi.link.developers.sdk.blockchain.api;

import com.github.kokochi.link.developers.sdk.blockchain.model.request.Request.*;
import com.github.kokochi.link.developers.sdk.blockchain.model.response.Response.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiClientGetTest {

    @Autowired
    private ApiClient apiClient;

    @Test
    public void wallet() {
        NonFungibleTokenMintRequest request = new NonFungibleTokenMintRequest();
        request.setOwnerAddress("tlink1dhtwpu3jnhtrna3caff544kswpql8dk28gfzqa");
        request.setOwnerSecret("JqqB1Jh47HFIBM7Yr8tinxSB6bQLdBBpmL44eqHvjkM=");
        request.setName("weaponToken");
        request.setToAddress("tlink1gqjznvpudy8pwzf6lknx6z4ykvxlpzx7el7qyf");
        GenericResponse<TransactionResponse> response = apiClient.mintNonFungible("92e755ee", "10000002", request);
        System.out.println("response :: " + response);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(1002);
    }
}
