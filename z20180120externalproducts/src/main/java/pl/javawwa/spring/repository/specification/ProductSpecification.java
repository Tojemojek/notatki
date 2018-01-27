package pl.javawwa.spring.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import pl.javawwa.spring.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    private Product product;

    //todo zamiast Product trzeba zrobić
    // ProductSearchDto który będzie miał dodatkowe pola np. większe niż mniejsze niż
    public ProductSpecification(Product filter) {
        this.product = filter;
    }

    @Override
    public Predicate toPredicate(Root<Product> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate p = criteriaBuilder.and();

        if (!StringUtils.isEmpty(product.getName())) {
            p.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + product.getName() + "%"));
        }

        if (product.getProductType() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("productType"), product.getProductType()));
        }

        return p;
    }


}
