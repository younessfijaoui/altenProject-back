package io.fijaoui.altenProject.entities;

import io.fijaoui.altenProject.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String code;
	private String name;
	private String description;
	private String image;
	private String category;
	private double price;
	private int quantity;
	private String internalReference;
	private String shellId;

	@Enumerated(EnumType.STRING)
	private InventoryStatus inventoryStatus;

	private int rating;

	@CreationTimestamp
	private LocalDate createdAt;
	@UpdateTimestamp
	private LocalDate updatedAt;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<BasketItem> basketItems = new HashSet<>();

}

