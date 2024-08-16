package org.example.carinventory.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash("car")
public class Car {
    private String id;
    private String motor;
    private String model;
    private int year;
    private String color;
}
