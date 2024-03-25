package com.anti.weblerschoolmanytomanygyepi.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "your_table_name")
public class YourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "your_table_generator")
    @TableGenerator(name = "your_table_generator",
            table = "id_generator",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            allocationSize = 1,
            initialValue = 1000)
    private Long id;

    private String name;
}
