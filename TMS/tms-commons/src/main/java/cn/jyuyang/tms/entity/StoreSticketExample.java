package cn.jyuyang.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreSticketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public StoreSticketExample() {
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

        public Criteria andManagerNameIsNull() {
            addCriterion("manager_name is null");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNotNull() {
            addCriterion("manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNameEqualTo(String value) {
            addCriterion("manager_name =", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotEqualTo(String value) {
            addCriterion("manager_name <>", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThan(String value) {
            addCriterion("manager_name >", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manager_name >=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThan(String value) {
            addCriterion("manager_name <", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThanOrEqualTo(String value) {
            addCriterion("manager_name <=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLike(String value) {
            addCriterion("manager_name like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotLike(String value) {
            addCriterion("manager_name not like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameIn(List<String> values) {
            addCriterion("manager_name in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotIn(List<String> values) {
            addCriterion("manager_name not in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameBetween(String value1, String value2) {
            addCriterion("manager_name between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotBetween(String value1, String value2) {
            addCriterion("manager_name not between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerMobileIsNull() {
            addCriterion("manager_mobile is null");
            return (Criteria) this;
        }

        public Criteria andManagerMobileIsNotNull() {
            addCriterion("manager_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andManagerMobileEqualTo(String value) {
            addCriterion("manager_mobile =", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileNotEqualTo(String value) {
            addCriterion("manager_mobile <>", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileGreaterThan(String value) {
            addCriterion("manager_mobile >", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("manager_mobile >=", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileLessThan(String value) {
            addCriterion("manager_mobile <", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileLessThanOrEqualTo(String value) {
            addCriterion("manager_mobile <=", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileLike(String value) {
            addCriterion("manager_mobile like", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileNotLike(String value) {
            addCriterion("manager_mobile not like", value, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileIn(List<String> values) {
            addCriterion("manager_mobile in", values, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileNotIn(List<String> values) {
            addCriterion("manager_mobile not in", values, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileBetween(String value1, String value2) {
            addCriterion("manager_mobile between", value1, value2, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andManagerMobileNotBetween(String value1, String value2) {
            addCriterion("manager_mobile not between", value1, value2, "managerMobile");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressIsNull() {
            addCriterion("ticket_store_address is null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressIsNotNull() {
            addCriterion("ticket_store_address is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressEqualTo(String value) {
            addCriterion("ticket_store_address =", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressNotEqualTo(String value) {
            addCriterion("ticket_store_address <>", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressGreaterThan(String value) {
            addCriterion("ticket_store_address >", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_store_address >=", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressLessThan(String value) {
            addCriterion("ticket_store_address <", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("ticket_store_address <=", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressLike(String value) {
            addCriterion("ticket_store_address like", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressNotLike(String value) {
            addCriterion("ticket_store_address not like", value, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressIn(List<String> values) {
            addCriterion("ticket_store_address in", values, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressNotIn(List<String> values) {
            addCriterion("ticket_store_address not in", values, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressBetween(String value1, String value2) {
            addCriterion("ticket_store_address between", value1, value2, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAddressNotBetween(String value1, String value2) {
            addCriterion("ticket_store_address not between", value1, value2, "ticketStoreAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoIsNull() {
            addCriterion("business_license_photo is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoIsNotNull() {
            addCriterion("business_license_photo is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoEqualTo(String value) {
            addCriterion("business_license_photo =", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoNotEqualTo(String value) {
            addCriterion("business_license_photo <>", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoGreaterThan(String value) {
            addCriterion("business_license_photo >", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_photo >=", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoLessThan(String value) {
            addCriterion("business_license_photo <", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoLessThanOrEqualTo(String value) {
            addCriterion("business_license_photo <=", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoLike(String value) {
            addCriterion("business_license_photo like", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoNotLike(String value) {
            addCriterion("business_license_photo not like", value, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoIn(List<String> values) {
            addCriterion("business_license_photo in", values, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoNotIn(List<String> values) {
            addCriterion("business_license_photo not in", values, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoBetween(String value1, String value2) {
            addCriterion("business_license_photo between", value1, value2, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePhotoNotBetween(String value1, String value2) {
            addCriterion("business_license_photo not between", value1, value2, "businessLicensePhoto");
            return (Criteria) this;
        }

        public Criteria andManagerCardIsNull() {
            addCriterion("manager_card is null");
            return (Criteria) this;
        }

        public Criteria andManagerCardIsNotNull() {
            addCriterion("manager_card is not null");
            return (Criteria) this;
        }

        public Criteria andManagerCardEqualTo(String value) {
            addCriterion("manager_card =", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardNotEqualTo(String value) {
            addCriterion("manager_card <>", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardGreaterThan(String value) {
            addCriterion("manager_card >", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardGreaterThanOrEqualTo(String value) {
            addCriterion("manager_card >=", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardLessThan(String value) {
            addCriterion("manager_card <", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardLessThanOrEqualTo(String value) {
            addCriterion("manager_card <=", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardLike(String value) {
            addCriterion("manager_card like", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardNotLike(String value) {
            addCriterion("manager_card not like", value, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardIn(List<String> values) {
            addCriterion("manager_card in", values, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardNotIn(List<String> values) {
            addCriterion("manager_card not in", values, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardBetween(String value1, String value2) {
            addCriterion("manager_card between", value1, value2, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardNotBetween(String value1, String value2) {
            addCriterion("manager_card not between", value1, value2, "managerCard");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeIsNull() {
            addCriterion("manager_card_before is null");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeIsNotNull() {
            addCriterion("manager_card_before is not null");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeEqualTo(String value) {
            addCriterion("manager_card_before =", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeNotEqualTo(String value) {
            addCriterion("manager_card_before <>", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeGreaterThan(String value) {
            addCriterion("manager_card_before >", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeGreaterThanOrEqualTo(String value) {
            addCriterion("manager_card_before >=", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeLessThan(String value) {
            addCriterion("manager_card_before <", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeLessThanOrEqualTo(String value) {
            addCriterion("manager_card_before <=", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeLike(String value) {
            addCriterion("manager_card_before like", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeNotLike(String value) {
            addCriterion("manager_card_before not like", value, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeIn(List<String> values) {
            addCriterion("manager_card_before in", values, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeNotIn(List<String> values) {
            addCriterion("manager_card_before not in", values, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeBetween(String value1, String value2) {
            addCriterion("manager_card_before between", value1, value2, "managerCardBefore");
            return (Criteria) this;
        }

        public Criteria andManagerCardBeforeNotBetween(String value1, String value2) {
            addCriterion("manager_card_before not between", value1, value2, "managerCardBefore");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNull() {
            addCriterion("store_longitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNotNull() {
            addCriterion("store_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeEqualTo(String value) {
            addCriterion("store_longitude =", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotEqualTo(String value) {
            addCriterion("store_longitude <>", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThan(String value) {
            addCriterion("store_longitude >", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_longitude >=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThan(String value) {
            addCriterion("store_longitude <", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThanOrEqualTo(String value) {
            addCriterion("store_longitude <=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLike(String value) {
            addCriterion("store_longitude like", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotLike(String value) {
            addCriterion("store_longitude not like", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIn(List<String> values) {
            addCriterion("store_longitude in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotIn(List<String> values) {
            addCriterion("store_longitude not in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeBetween(String value1, String value2) {
            addCriterion("store_longitude between", value1, value2, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotBetween(String value1, String value2) {
            addCriterion("store_longitude not between", value1, value2, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNull() {
            addCriterion("store_latitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNotNull() {
            addCriterion("store_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeEqualTo(String value) {
            addCriterion("store_latitude =", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotEqualTo(String value) {
            addCriterion("store_latitude <>", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThan(String value) {
            addCriterion("store_latitude >", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_latitude >=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThan(String value) {
            addCriterion("store_latitude <", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThanOrEqualTo(String value) {
            addCriterion("store_latitude <=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLike(String value) {
            addCriterion("store_latitude like", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotLike(String value) {
            addCriterion("store_latitude not like", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIn(List<String> values) {
            addCriterion("store_latitude in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotIn(List<String> values) {
            addCriterion("store_latitude not in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeBetween(String value1, String value2) {
            addCriterion("store_latitude between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotBetween(String value1, String value2) {
            addCriterion("store_latitude not between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterIsNull() {
            addCriterion("manager_card_after is null");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterIsNotNull() {
            addCriterion("manager_card_after is not null");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterEqualTo(String value) {
            addCriterion("manager_card_after =", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterNotEqualTo(String value) {
            addCriterion("manager_card_after <>", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterGreaterThan(String value) {
            addCriterion("manager_card_after >", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterGreaterThanOrEqualTo(String value) {
            addCriterion("manager_card_after >=", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterLessThan(String value) {
            addCriterion("manager_card_after <", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterLessThanOrEqualTo(String value) {
            addCriterion("manager_card_after <=", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterLike(String value) {
            addCriterion("manager_card_after like", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterNotLike(String value) {
            addCriterion("manager_card_after not like", value, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterIn(List<String> values) {
            addCriterion("manager_card_after in", values, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterNotIn(List<String> values) {
            addCriterion("manager_card_after not in", values, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterBetween(String value1, String value2) {
            addCriterion("manager_card_after between", value1, value2, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andManagerCardAfterNotBetween(String value1, String value2) {
            addCriterion("manager_card_after not between", value1, value2, "managerCardAfter");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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