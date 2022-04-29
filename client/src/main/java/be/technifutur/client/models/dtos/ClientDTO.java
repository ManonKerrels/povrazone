package be.technifutur.client.models.dtos;

import be.technifutur.client.models.entities.CartItem;
import be.technifutur.client.models.entities.Client;
import be.technifutur.client.models.entities.Product;
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

        public static ProductDto of(Product p)
        {
            if(p == null) return null;

            return new ProductDto(p.getId(), p.getName(), p.getReference());
        }
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

            public static ProductDto of(Product p)
            {
                if(p == null) return null;

                return new ProductDto(p.getReference());
            }
        }

        public static CartItemDto of(CartItem ci)
        {
            if(ci == null) return null;

            return new CartItemDto(ProductDto.of(ci.getProduct()), ci.getQuantity());
        }
    }

    public static ClientDTO of(Client c)
    {
        if(c == null) return null;

        return new ClientDTO(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getUsername(),
                c.getPassword(),
                c.getMail(),
                c.getAddress(),
                c.getReference(),
                c.getFavorites() == null ? null : c.getFavorites().stream().map(ProductDto::of).toList(),
                c.getCart() == null ? null : c.getCart().stream().map(CartItemDto::of).toList()
        );
    }
}
