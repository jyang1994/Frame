package cn.jyuyang.tms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TicketOutExample() {
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

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutStoreIsNull() {
            addCriterion("out_store is null");
            return (Criteria) this;
        }

        public Criteria andOutStoreIsNotNull() {
            addCriterion("out_store is not null");
            return (Criteria) this;
        }

        public Criteria andOutStoreEqualTo(String value) {
            addCriterion("out_store =", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreNotEqualTo(String value) {
            addCriterion("out_store <>", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreGreaterThan(String value) {
            addCriterion("out_store >", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreGreaterThanOrEqualTo(String value) {
            addCriterion("out_store >=", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreLessThan(String value) {
            addCriterion("out_store <", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreLessThanOrEqualTo(String value) {
            addCriterion("out_store <=", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreLike(String value) {
            addCriterion("out_store like", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreNotLike(String value) {
            addCriterion("out_store not like", value, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreIn(List<String> values) {
            addCriterion("out_store in", values, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreNotIn(List<String> values) {
            addCriterion("out_store not in", values, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreBetween(String value1, String value2) {
            addCriterion("out_store between", value1, value2, "outStore");
            return (Criteria) this;
        }

        public Criteria andOutStoreNotBetween(String value1, String value2) {
            addCriterion("out_store not between", value1, value2, "outStore");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andOutNumIsNull() {
            addCriterion("out_num is null");
            return (Criteria) this;
        }

        public Criteria andOutNumIsNotNull() {
            addCriterion("out_num is not null");
            return (Criteria) this;
        }

        public Criteria andOutNumEqualTo(Integer value) {
            addCriterion("out_num =", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotEqualTo(Integer value) {
            addCriterion("out_num <>", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumGreaterThan(Integer value) {
            addCriterion("out_num >", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_num >=", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumLessThan(Integer value) {
            addCriterion("out_num <", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumLessThanOrEqualTo(Integer value) {
            addCriterion("out_num <=", value, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumIn(List<Integer> values) {
            addCriterion("out_num in", values, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotIn(List<Integer> values) {
            addCriterion("out_num not in", values, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumBetween(Integer value1, Integer value2) {
            addCriterion("out_num between", value1, value2, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutNumNotBetween(Integer value1, Integer value2) {
            addCriterion("out_num not between", value1, value2, "outNum");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketIsNull() {
            addCriterion("out_start_ticket is null");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketIsNotNull() {
            addCriterion("out_start_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketEqualTo(String value) {
            addCriterion("out_start_ticket =", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketNotEqualTo(String value) {
            addCriterion("out_start_ticket <>", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketGreaterThan(String value) {
            addCriterion("out_start_ticket >", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketGreaterThanOrEqualTo(String value) {
            addCriterion("out_start_ticket >=", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketLessThan(String value) {
            addCriterion("out_start_ticket <", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketLessThanOrEqualTo(String value) {
            addCriterion("out_start_ticket <=", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketLike(String value) {
            addCriterion("out_start_ticket like", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketNotLike(String value) {
            addCriterion("out_start_ticket not like", value, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketIn(List<String> values) {
            addCriterion("out_start_ticket in", values, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketNotIn(List<String> values) {
            addCriterion("out_start_ticket not in", values, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketBetween(String value1, String value2) {
            addCriterion("out_start_ticket between", value1, value2, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutStartTicketNotBetween(String value1, String value2) {
            addCriterion("out_start_ticket not between", value1, value2, "outStartTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketIsNull() {
            addCriterion("out_end_ticket is null");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketIsNotNull() {
            addCriterion("out_end_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketEqualTo(String value) {
            addCriterion("out_end_ticket =", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketNotEqualTo(String value) {
            addCriterion("out_end_ticket <>", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketGreaterThan(String value) {
            addCriterion("out_end_ticket >", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketGreaterThanOrEqualTo(String value) {
            addCriterion("out_end_ticket >=", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketLessThan(String value) {
            addCriterion("out_end_ticket <", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketLessThanOrEqualTo(String value) {
            addCriterion("out_end_ticket <=", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketLike(String value) {
            addCriterion("out_end_ticket like", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketNotLike(String value) {
            addCriterion("out_end_ticket not like", value, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketIn(List<String> values) {
            addCriterion("out_end_ticket in", values, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketNotIn(List<String> values) {
            addCriterion("out_end_ticket not in", values, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketBetween(String value1, String value2) {
            addCriterion("out_end_ticket between", value1, value2, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOutEndTicketNotBetween(String value1, String value2) {
            addCriterion("out_end_ticket not between", value1, value2, "outEndTicket");
            return (Criteria) this;
        }

        public Criteria andOnePriceIsNull() {
            addCriterion("one_price is null");
            return (Criteria) this;
        }

        public Criteria andOnePriceIsNotNull() {
            addCriterion("one_price is not null");
            return (Criteria) this;
        }

        public Criteria andOnePriceEqualTo(BigDecimal value) {
            addCriterion("one_price =", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotEqualTo(BigDecimal value) {
            addCriterion("one_price <>", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceGreaterThan(BigDecimal value) {
            addCriterion("one_price >", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("one_price >=", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceLessThan(BigDecimal value) {
            addCriterion("one_price <", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("one_price <=", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceIn(List<BigDecimal> values) {
            addCriterion("one_price in", values, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotIn(List<BigDecimal> values) {
            addCriterion("one_price not in", values, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_price between", value1, value2, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_price not between", value1, value2, "onePrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andOutStateIsNull() {
            addCriterion("out_state is null");
            return (Criteria) this;
        }

        public Criteria andOutStateIsNotNull() {
            addCriterion("out_state is not null");
            return (Criteria) this;
        }

        public Criteria andOutStateEqualTo(String value) {
            addCriterion("out_state =", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotEqualTo(String value) {
            addCriterion("out_state <>", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateGreaterThan(String value) {
            addCriterion("out_state >", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateGreaterThanOrEqualTo(String value) {
            addCriterion("out_state >=", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateLessThan(String value) {
            addCriterion("out_state <", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateLessThanOrEqualTo(String value) {
            addCriterion("out_state <=", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateLike(String value) {
            addCriterion("out_state like", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotLike(String value) {
            addCriterion("out_state not like", value, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateIn(List<String> values) {
            addCriterion("out_state in", values, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotIn(List<String> values) {
            addCriterion("out_state not in", values, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateBetween(String value1, String value2) {
            addCriterion("out_state between", value1, value2, "outState");
            return (Criteria) this;
        }

        public Criteria andOutStateNotBetween(String value1, String value2) {
            addCriterion("out_state not between", value1, value2, "outState");
            return (Criteria) this;
        }

        public Criteria andOutAccountIsNull() {
            addCriterion("out_account is null");
            return (Criteria) this;
        }

        public Criteria andOutAccountIsNotNull() {
            addCriterion("out_account is not null");
            return (Criteria) this;
        }

        public Criteria andOutAccountEqualTo(String value) {
            addCriterion("out_account =", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountNotEqualTo(String value) {
            addCriterion("out_account <>", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountGreaterThan(String value) {
            addCriterion("out_account >", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountGreaterThanOrEqualTo(String value) {
            addCriterion("out_account >=", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountLessThan(String value) {
            addCriterion("out_account <", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountLessThanOrEqualTo(String value) {
            addCriterion("out_account <=", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountLike(String value) {
            addCriterion("out_account like", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountNotLike(String value) {
            addCriterion("out_account not like", value, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountIn(List<String> values) {
            addCriterion("out_account in", values, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountNotIn(List<String> values) {
            addCriterion("out_account not in", values, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountBetween(String value1, String value2) {
            addCriterion("out_account between", value1, value2, "outAccount");
            return (Criteria) this;
        }

        public Criteria andOutAccountNotBetween(String value1, String value2) {
            addCriterion("out_account not between", value1, value2, "outAccount");
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