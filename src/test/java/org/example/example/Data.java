package org.example.example;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private String name;
    private String email;
    private String cur_address;
    private String per_address;
}
