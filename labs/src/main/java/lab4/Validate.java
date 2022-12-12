package lab4;

import lab1.Product;

import javax.validation.*;
import java.util.Set;

public class Validate {
    public Product validateProduct(Product obj) throws ValidationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(obj);
        if (violations.isEmpty())
            return obj;

        StringBuilder sb=new StringBuilder("\n");
        for (var violation : violations) {
            sb.append("Invalid value : ").append(violation.getInvalidValue()).append(" " + violation.getMessage() + "\n");
        }
        throw new ValidationException(sb.toString());
    }
}
