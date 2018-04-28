package cn.jyuyang.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class CustomerPhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CustomerPhotoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCardBeforeIsNull() {
            addCriterion("card_before is null");
            return (Criteria) this;
        }

        public Criteria andCardBeforeIsNotNull() {
            addCriterion("card_before is not null");
            return (Criteria) this;
        }

        public Criteria andCardBeforeEqualTo(String value) {
            addCriterion("card_before =", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeNotEqualTo(String value) {
            addCriterion("card_before <>", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeGreaterThan(String value) {
            addCriterion("card_before >", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeGreaterThanOrEqualTo(String value) {
            addCriterion("card_before >=", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeLessThan(String value) {
            addCriterion("card_before <", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeLessThanOrEqualTo(String value) {
            addCriterion("card_before <=", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeLike(String value) {
            addCriterion("card_before like", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeNotLike(String value) {
            addCriterion("card_before not like", value, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeIn(List<String> values) {
            addCriterion("card_before in", values, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeNotIn(List<String> values) {
            addCriterion("card_before not in", values, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeBetween(String value1, String value2) {
            addCriterion("card_before between", value1, value2, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardBeforeNotBetween(String value1, String value2) {
            addCriterion("card_before not between", value1, value2, "cardBefore");
            return (Criteria) this;
        }

        public Criteria andCardAfterIsNull() {
            addCriterion("card_after is null");
            return (Criteria) this;
        }

        public Criteria andCardAfterIsNotNull() {
            addCriterion("card_after is not null");
            return (Criteria) this;
        }

        public Criteria andCardAfterEqualTo(String value) {
            addCriterion("card_after =", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterNotEqualTo(String value) {
            addCriterion("card_after <>", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterGreaterThan(String value) {
            addCriterion("card_after >", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterGreaterThanOrEqualTo(String value) {
            addCriterion("card_after >=", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterLessThan(String value) {
            addCriterion("card_after <", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterLessThanOrEqualTo(String value) {
            addCriterion("card_after <=", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterLike(String value) {
            addCriterion("card_after like", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterNotLike(String value) {
            addCriterion("card_after not like", value, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterIn(List<String> values) {
            addCriterion("card_after in", values, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterNotIn(List<String> values) {
            addCriterion("card_after not in", values, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterBetween(String value1, String value2) {
            addCriterion("card_after between", value1, value2, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andCardAfterNotBetween(String value1, String value2) {
            addCriterion("card_after not between", value1, value2, "cardAfter");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoIsNull() {
            addCriterion("person_photo is null");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoIsNotNull() {
            addCriterion("person_photo is not null");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoEqualTo(String value) {
            addCriterion("person_photo =", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoNotEqualTo(String value) {
            addCriterion("person_photo <>", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoGreaterThan(String value) {
            addCriterion("person_photo >", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("person_photo >=", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoLessThan(String value) {
            addCriterion("person_photo <", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoLessThanOrEqualTo(String value) {
            addCriterion("person_photo <=", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoLike(String value) {
            addCriterion("person_photo like", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoNotLike(String value) {
            addCriterion("person_photo not like", value, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoIn(List<String> values) {
            addCriterion("person_photo in", values, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoNotIn(List<String> values) {
            addCriterion("person_photo not in", values, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoBetween(String value1, String value2) {
            addCriterion("person_photo between", value1, value2, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andPersonPhotoNotBetween(String value1, String value2) {
            addCriterion("person_photo not between", value1, value2, "personPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}