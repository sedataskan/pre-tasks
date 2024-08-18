package org.example.carinventory.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash("car")
public class Car {
    private String id;
    private String engine;
    private String model;
    private int year;
    private String color;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String serialNumber;
    //TODO: createdAt ve updatedAt otomatik doldur *
    //TODO: yil 0 dan küçük 2040 dan büyük olamaz diye validasyon koaylım. Spring validation ile
    //TODO: Model boş olamaz  validasyon ekle. Spring validation ile
}
