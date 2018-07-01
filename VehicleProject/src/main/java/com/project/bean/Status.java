package com.project.bean;

import lombok.*;

import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Status {

    private Integer idStatus;

    private String description;

}
