package org.example.carinventory.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Model can not be empty")
    private String model;

    @Min(value = 0, message = "Year can not be less than 0")
    @Max(value = 2040, message = "Year can not be greater than 2040")
    private int year;
    private String color;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String serialNumber;
    //TODO: createdAt ve updatedAt otomatik doldur *
    //TODO: yil 0 dan küçük 2040 dan büyük olamaz diye validasyon koaylım. Spring validation ile *
    //TODO: Model boş olamaz  validasyon ekle. Spring validation ile*
}
