package cn.jyuyang.tms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SalesExample() {
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

        public Criteria andSaleStoreIdIsNull() {
            addCriterion("sale_store_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdIsNotNull() {
            addCriterion("sale_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdEqualTo(Integer value) {
            addCriterion("sale_store_id =", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdNotEqualTo(Integer value) {
            addCriterion("sale_store_id <>", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdGreaterThan(Integer value) {
            addCriterion("sale_store_id >", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_store_id >=", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdLessThan(Integer value) {
            addCriterion("sale_store_id <", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_store_id <=", value, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdIn(List<Integer> values) {
            addCriterion("sale_store_id in", values, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdNotIn(List<Integer> values) {
            addCriterion("sale_store_id not in", values, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_store_id between", value1, value2, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_store_id not between", value1, value2, "saleStoreId");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumIsNull() {
            addCriterion("sale_ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumIsNotNull() {
            addCriterion("sale_ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumEqualTo(String value) {
            addCriterion("sale_ticket_num =", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumNotEqualTo(String value) {
            addCriterion("sale_ticket_num <>", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumGreaterThan(String value) {
            addCriterion("sale_ticket_num >", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("sale_ticket_num >=", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumLessThan(String value) {
            addCriterion("sale_ticket_num <", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumLessThanOrEqualTo(String value) {
            addCriterion("sale_ticket_num <=", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumLike(String value) {
            addCriterion("sale_ticket_num like", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumNotLike(String value) {
            addCriterion("sale_ticket_num not like", value, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumIn(List<String> values) {
            addCriterion("sale_ticket_num in", values, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumNotIn(List<String> values) {
            addCriterion("sale_ticket_num not in", values, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumBetween(String value1, String value2) {
            addCriterion("sale_ticket_num between", value1, value2, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andSaleTicketNumNotBetween(String value1, String value2) {
            addCriterion("sale_ticket_num not between", value1, value2, "saleTicketNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSaleStateIsNull() {
            addCriterion("sale_state is null");
            return (Criteria) this;
        }

        public Criteria andSaleStateIsNotNull() {
            addCriterion("sale_state is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStateEqualTo(String value) {
            addCriterion("sale_state =", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateNotEqualTo(String value) {
            addCriterion("sale_state <>", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateGreaterThan(String value) {
            addCriterion("sale_state >", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateGreaterThanOrEqualTo(String value) {
            addCriterion("sale_state >=", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateLessThan(String value) {
            addCriterion("sale_state <", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateLessThanOrEqualTo(String value) {
            addCriterion("sale_state <=", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateLike(String value) {
            addCriterion("sale_state like", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateNotLike(String value) {
            addCriterion("sale_state not like", value, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateIn(List<String> values) {
            addCriterion("sale_state in", values, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateNotIn(List<String> values) {
            addCriterion("sale_state not in", values, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateBetween(String value1, String value2) {
            addCriterion("sale_state between", value1, value2, "saleState");
            return (Criteria) this;
        }

        public Criteria andSaleStateNotBetween(String value1, String value2) {
            addCriterion("sale_state not between", value1, value2, "saleState");
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