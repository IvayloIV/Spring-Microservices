package soft2run.com.stripedemo.exception;

import com.stripe.exception.StripeException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandler {

    @AfterThrowing(value = "execution(* soft2run.com.stripedemo.*.*(..))", throwing = "ex")
    public void doOnCardException(JoinPoint jp, StripeException ex) throws StripeAdapterException {
        Class withinType = jp.getSourceLocation().getWithinType();
        final Logger logger = LoggerFactory.getLogger(withinType);
        String code = ex.getCode();
        String message = ex.getMessage();
        logger.error(message);
        throw new StripeAdapterException(ex.getMessage());
    }
}
