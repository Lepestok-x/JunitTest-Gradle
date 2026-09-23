package org.example;
import java.time.Instant;
public class ClientStore extends StoreParent {
    public ClientStore path(String path) {
        this.path = path;
        return this;
    }
    public ClientStore parameter(String parameter) {
        this.parameter = parameter;
        return this;
    }
    public ClientStore id(int id) {
        this.id = id;
        return this;
    }
    public ClientStore petId(int petId) {
        this.petId = petId;
        return this;
    }
    public ClientStore code(int code) {
        this.code = code;
        return this;
    }
    public ClientStore quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    public ClientStore shapeDate() {
        this.shipDate = Instant.now();
        return this;
    }
    public ClientStore status(String status) {
        this.status = status;
        return this;
    }
    public ClientStore complete(boolean complete) {
        this.complete = complete;
        return this;
    }
    public <T> ClientStore body(T body) {
        this.body = body;
        return this;
    }
    public void getStore() {
        get();
    }
    public <T> T postStore(T body, Class<T> clazz) {
        return post(body, clazz);
    }
}
