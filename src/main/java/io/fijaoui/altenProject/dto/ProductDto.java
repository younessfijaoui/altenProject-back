package io.fijaoui.altenProject.dto;

import io.fijaoui.altenProject.entities.Product;
import io.fijaoui.altenProject.enums.InventoryStatus;

import java.time.LocalDate;

public record ProductDto(
		long id,
		String code,
		String name,
		String description,
		String image,
		String category,
		double price,
		int quantity,
		String internalReference,
		String shellId,
		String inventoryStatus,
		int rating,
		LocalDate createdAt,
		LocalDate updatedAt
) {

	public static ProductDto fromEntity(Product product) {
		return new ProductDto(
				product.getId(),
				product.getCode(),
				product.getName(),
				product.getDescription(),
				product.getImage(),
				product.getCategory(),
				product.getPrice(),
				product.getQuantity(),
				product.getInternalReference(),
				product.getShellId(),
				product.getCategory(),
				product.getRating(),
				product.getCreatedAt(),
				product.getUpdatedAt()
		);
	}

	public Product toEntity() {
		Product product = new Product();
		product.setId(id());
		product.setCode(code());
		product.setName(name());
		product.setDescription(description());
		product.setImage(image());
		product.setCategory(category());
		product.setPrice(price());
		product.setQuantity(quantity());
		product.setInternalReference(internalReference());
		product.setShellId(shellId());
		product.setCategory(category());
		product.setRating(rating());
		return product;
	}
}
