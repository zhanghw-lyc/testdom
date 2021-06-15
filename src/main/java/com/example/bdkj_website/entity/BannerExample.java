package com.example.bdkj_website.entity;

import java.util.ArrayList;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("IMAGE =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("IMAGE <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("IMAGE >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("IMAGE <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("IMAGE <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("IMAGE like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("IMAGE not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("IMAGE in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("IMAGE not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("IMAGE between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("IMAGE not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andWebSiteIsNull() {
            addCriterion("WEB_SITE is null");
            return (Criteria) this;
        }

        public Criteria andWebSiteIsNotNull() {
            addCriterion("WEB_SITE is not null");
            return (Criteria) this;
        }

        public Criteria andWebSiteEqualTo(String value) {
            addCriterion("WEB_SITE =", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            addCriterion("WEB_SITE <>", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteGreaterThan(String value) {
            addCriterion("WEB_SITE >", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_SITE >=", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteLessThan(String value) {
            addCriterion("WEB_SITE <", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            addCriterion("WEB_SITE <=", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteLike(String value) {
            addCriterion("WEB_SITE like", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteNotLike(String value) {
            addCriterion("WEB_SITE not like", value, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteIn(List<String> values) {
            addCriterion("WEB_SITE in", values, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            addCriterion("WEB_SITE not in", values, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            addCriterion("WEB_SITE between", value1, value2, "webSite");
            return (Criteria) this;
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            addCriterion("WEB_SITE not between", value1, value2, "webSite");
            return (Criteria) this;
        }

        public Criteria andAtt1IsNull() {
            addCriterion("ATT1 is null");
            return (Criteria) this;
        }

        public Criteria andAtt1IsNotNull() {
            addCriterion("ATT1 is not null");
            return (Criteria) this;
        }

        public Criteria andAtt1EqualTo(String value) {
            addCriterion("ATT1 =", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1NotEqualTo(String value) {
            addCriterion("ATT1 <>", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1GreaterThan(String value) {
            addCriterion("ATT1 >", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1GreaterThanOrEqualTo(String value) {
            addCriterion("ATT1 >=", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1LessThan(String value) {
            addCriterion("ATT1 <", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1LessThanOrEqualTo(String value) {
            addCriterion("ATT1 <=", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1Like(String value) {
            addCriterion("ATT1 like", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1NotLike(String value) {
            addCriterion("ATT1 not like", value, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1In(List<String> values) {
            addCriterion("ATT1 in", values, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1NotIn(List<String> values) {
            addCriterion("ATT1 not in", values, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1Between(String value1, String value2) {
            addCriterion("ATT1 between", value1, value2, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt1NotBetween(String value1, String value2) {
            addCriterion("ATT1 not between", value1, value2, "att1");
            return (Criteria) this;
        }

        public Criteria andAtt2IsNull() {
            addCriterion("ATT2 is null");
            return (Criteria) this;
        }

        public Criteria andAtt2IsNotNull() {
            addCriterion("ATT2 is not null");
            return (Criteria) this;
        }

        public Criteria andAtt2EqualTo(String value) {
            addCriterion("ATT2 =", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2NotEqualTo(String value) {
            addCriterion("ATT2 <>", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2GreaterThan(String value) {
            addCriterion("ATT2 >", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2GreaterThanOrEqualTo(String value) {
            addCriterion("ATT2 >=", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2LessThan(String value) {
            addCriterion("ATT2 <", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2LessThanOrEqualTo(String value) {
            addCriterion("ATT2 <=", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2Like(String value) {
            addCriterion("ATT2 like", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2NotLike(String value) {
            addCriterion("ATT2 not like", value, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2In(List<String> values) {
            addCriterion("ATT2 in", values, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2NotIn(List<String> values) {
            addCriterion("ATT2 not in", values, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2Between(String value1, String value2) {
            addCriterion("ATT2 between", value1, value2, "att2");
            return (Criteria) this;
        }

        public Criteria andAtt2NotBetween(String value1, String value2) {
            addCriterion("ATT2 not between", value1, value2, "att2");
            return (Criteria) this;
        }
    }

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