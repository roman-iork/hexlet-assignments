package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withTitleCont(params.getTitleCont())
                .and(withCategoryId(params.getCategoryId()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withPriceGt(params.getPriceGt()))
                .and(withRatingGt(params.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String title) {
        return (root, query, cb) -> title == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")),
                "%" + title.toLowerCase() + "%");
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"),
                categoryId);
    }

    private Specification<Product> withPriceLt(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() : cb.lessThan(root.get("price"),
                price);
    }

    private Specification<Product> withPriceGt(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() : cb.greaterThan(root.get("price"),
                price);
    }

    private Specification<Product> withRatingGt(Double rating) {
        return (root, query, cb) -> rating == null ? cb.conjunction() : cb.greaterThan(root.get("rating"),
                rating);
    }
}
// END
