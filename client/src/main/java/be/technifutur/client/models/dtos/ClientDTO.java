package be.technifutur.client.models.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class ClientDTO implements Serializable
{
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String mail;
    private final String address;
    private final String reference;
    private final List<ProductDto> favorites;
    private final List<CartItemDto> cart;

    @Data
    public static class ProductDto implements Serializable
    {
        private final Long id;
        private final String name;
        private final UUID reference;
    }

    @Data
    public static class CartItemDto implements Serializable
    {
        private final ProductDto product;
        private final int quantity;

        @Data
        public static class ProductDto implements Serializable
        {
            private final UUID reference;
        }
    }
}
