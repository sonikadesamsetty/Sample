package com.app.sony.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity  user;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(user, that.user) &&
                Objects.equals(quantity, that.quantity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, product, user, quantity);
    }
    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
