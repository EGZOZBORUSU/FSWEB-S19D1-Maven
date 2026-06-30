package com.workintech.s18d2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Boolean isGrownOnTree;

    public void setGrownOnTree(boolean grownOnTree) { this.isGrownOnTree = grownOnTree; }
    public boolean isGrownOnTree() { return isGrownOnTree != null && isGrownOnTree; }
}