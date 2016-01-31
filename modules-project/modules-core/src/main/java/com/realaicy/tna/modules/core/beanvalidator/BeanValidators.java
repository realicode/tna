package com.realaicy.tna.modules.core.beanvalidator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


/**
 * JSR303 Validator(Hibernate Validator)工具类.
 * <p/>
 * ConstraintViolation中包含propertyPath, message 和invalidValue等信息.
 * 提供了各种convert方法，适合不同的i18n需求:
 * 1. List<String>, String内容为message
 * 2. List<String>, String内容为propertyPath + separator + message
 * 3. Map<propertyPath, message>
 * <p/>
 * 详情见wiki: https://github.com/springside/springside4/wiki/HibernateValidator
 *
 * @author realaicy
 */
@SuppressWarnings("unused")
public final class BeanValidators {

    /**
     * Do not instantiate BeanValidators.
     */
    private BeanValidators() {

    }

    /**
     * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException, 而不是返回constraintViolations.
     *
     * @param validator the validator
     * @param object    the object
     * @param groups    the groups
     * @throws ConstraintViolationException the constraint violation exception
     */
    public static void validateWithException(final Validator validator, final Object object, final Class<?>... groups)
            throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    /**
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>中为List<message>.
     *
     * @param e the e
     * @return the list
     */
    public static List<String> extractMessage(final ConstraintViolationException e) {
        return extractMessage(e.getConstraintViolations());
    }

    /**
     * 辅助方法, 转换Set<ConstraintViolation>为List<message>
     *
     * @param constraintViolations the constraint violations
     * @return the list
     */
    public static List<String> extractMessage(final Set<? extends ConstraintViolation> constraintViolations) {
        List<String> errorMessages = Lists.newArrayList();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages;
    }

    /**
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为Map<property, message>.
     *
     * @param e the e
     * @return the map
     */
    public static Map<String, String> extractPropertyAndMessage(final ConstraintViolationException e) {
        return extractPropertyAndMessage(e.getConstraintViolations());
    }

    /**
     * 辅助方法, 转换Set<ConstraintViolation>为Map<property, message>.
     *
     * @param constraintViolations the constraint violations
     * @return the map
     */
    public static Map<String, String> extractPropertyAndMessage(
            final Set<? extends ConstraintViolation> constraintViolations) {
        Map<String, String> errorMessages = Maps.newHashMap();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return errorMessages;
    }

    /**
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<propertyPath message>.
     *
     * @param e the e
     * @return the list
     */
    public static List<String> extractPropertyAndMessageAsList(final ConstraintViolationException e) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), " ");
    }

    /**
     * 辅助方法, 转换Set<ConstraintViolations>为List<propertyPath message>.
     *
     * @param constraintViolations the constraint violations
     * @return the list
     */
    public static List<String> extractPropertyAndMessageAsList(final Set<? extends ConstraintViolation>
                                                                       constraintViolations) {
        return extractPropertyAndMessageAsList(constraintViolations, " ");
    }

    /**
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<propertyPath + separator + message>.
     *
     * @param e         the e
     * @param separator the separator
     * @return the list
     */
    public static List<String> extractPropertyAndMessageAsList(
            final ConstraintViolationException e, final String separator) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
    }

    /**
     * 辅助方法, 转换Set<ConstraintViolation>为List<propertyPath + separator + message>.
     *
     * @param constraintViolations the constraint violations
     * @param separator            the separator
     * @return the list
     */
    public static List<String> extractPropertyAndMessageAsList(
            final Set<? extends ConstraintViolation> constraintViolations,
            final String separator) {
        List<String> errorMessages = Lists.newArrayList();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getPropertyPath() + separator + violation.getMessage());
        }
        return errorMessages;
    }
}