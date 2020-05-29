package com.ymm.ebatis.meta;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 章多亮
 * @since 2020/5/27 19:03
 */
public interface ConditionMeta {
    Map<Class<? extends Annotation>, List<FieldMeta>> getQueryClauses(Object instance);

    Class<?> getType();

    default Optional<Annotation> getQueryClauseAnnotation() {
        return Optional.empty();
    }

    /**
     * 判断当前字段是否是基本类型，基本类型统一定义了
     *
     * @return 如果是基本类型，返回<code>true</code>
     */
    boolean isBasic();

    /**
     * 判断当前字段是否是脚本类型
     *
     * @return 如果是脚本，返回<code>true</code>
     * @see com.ymm.ebatis.domain.Script 脚本
     */
    boolean isScript();

    /**
     * 判断当前字段是否是范围类型
     *
     * @return 如果是范围，返回<code>true</code>
     * @see com.ymm.ebatis.annotation.Range 范围
     */
    boolean isRange();

    /**
     * 判断当前字段类型是否是数组类型
     *
     * @return 如果是数组类型，返回<code>true</code>
     */
    boolean isArray();

    /**
     * 判断当前字段是否是集合类型
     *
     * @return 如果是结合类型，发挥<code>true</code>
     */
    boolean isCollection();

    /**
     * 判断当前字段是否是数组或者集合
     *
     * @return 如果是数组或者集合，返回<code>true</code>
     */
    boolean isArrayOrCollection();

    /**
     * 判断当前条件是否是基本类型数据或者集合
     *
     * @return 如果是基本类型数组或者集合，返回<code>true</code>
     */
    boolean isBasicArrayOrCollection();

    String getName();

    <A extends Annotation> Optional<A> findAttributeAnnotation(Class<A> annotationClass);
}
