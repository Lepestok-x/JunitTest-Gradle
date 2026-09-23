package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Store-pet")
public class Store {

    @Test
    void testGetStore() {
        new ClientStore()
            .path("/store/inventory")
            .code(200)
            .getStore();
        int id = FakerEntity.randomId();
        int quantity = FakerEntity.quantity();
        String status = FakerEntity.status();
        boolean complete = FakerEntity.complete();
        StoreDTO expected = new StoreDTO(id, id, quantity, date(), status, complete);
        StoreDTO actual = new ClientStore()
            .path("/store/order")
            .body(expected)
            .code(200)
            .postStore(expected, StoreDTO.class);
        assertAll("Проверяем магазин", () ->
            assertNotNull(actual), () ->
            assertEquals(expected.id(), actual.id()), () ->
            assertEquals(expected.petId(), actual.petId()), () ->
            assertEquals(expected.quantity(), actual.quantity()), () ->
            assertEquals(expected.shipDate(), actual.shipDate()), () ->
            assertEquals(expected.status(), actual.status()), () ->
            assertEquals(expected.complete(), actual.complete()));
    }
    public Instant date() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
