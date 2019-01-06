package com.pan.blog.entity;

import java.util.ArrayList;
import java.util.List;

public class SiteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SiteInfoExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArticleNumIsNull() {
            addCriterion("article_num is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumIsNotNull() {
            addCriterion("article_num is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumEqualTo(Long value) {
            addCriterion("article_num =", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotEqualTo(Long value) {
            addCriterion("article_num <>", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThan(Long value) {
            addCriterion("article_num >", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThanOrEqualTo(Long value) {
            addCriterion("article_num >=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThan(Long value) {
            addCriterion("article_num <", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThanOrEqualTo(Long value) {
            addCriterion("article_num <=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumIn(List<Long> values) {
            addCriterion("article_num in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotIn(List<Long> values) {
            addCriterion("article_num not in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumBetween(Long value1, Long value2) {
            addCriterion("article_num between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotBetween(Long value1, Long value2) {
            addCriterion("article_num not between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumIsNull() {
            addCriterion("catalog_num is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNumIsNotNull() {
            addCriterion("catalog_num is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNumEqualTo(Integer value) {
            addCriterion("catalog_num =", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumNotEqualTo(Integer value) {
            addCriterion("catalog_num <>", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumGreaterThan(Integer value) {
            addCriterion("catalog_num >", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("catalog_num >=", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumLessThan(Integer value) {
            addCriterion("catalog_num <", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumLessThanOrEqualTo(Integer value) {
            addCriterion("catalog_num <=", value, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumIn(List<Integer> values) {
            addCriterion("catalog_num in", values, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumNotIn(List<Integer> values) {
            addCriterion("catalog_num not in", values, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumBetween(Integer value1, Integer value2) {
            addCriterion("catalog_num between", value1, value2, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andCatalogNumNotBetween(Integer value1, Integer value2) {
            addCriterion("catalog_num not between", value1, value2, "catalogNum");
            return (Criteria) this;
        }

        public Criteria andRunDaysIsNull() {
            addCriterion("run_days is null");
            return (Criteria) this;
        }

        public Criteria andRunDaysIsNotNull() {
            addCriterion("run_days is not null");
            return (Criteria) this;
        }

        public Criteria andRunDaysEqualTo(Integer value) {
            addCriterion("run_days =", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysNotEqualTo(Integer value) {
            addCriterion("run_days <>", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysGreaterThan(Integer value) {
            addCriterion("run_days >", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("run_days >=", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysLessThan(Integer value) {
            addCriterion("run_days <", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysLessThanOrEqualTo(Integer value) {
            addCriterion("run_days <=", value, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysIn(List<Integer> values) {
            addCriterion("run_days in", values, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysNotIn(List<Integer> values) {
            addCriterion("run_days not in", values, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysBetween(Integer value1, Integer value2) {
            addCriterion("run_days between", value1, value2, "runDays");
            return (Criteria) this;
        }

        public Criteria andRunDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("run_days not between", value1, value2, "runDays");
            return (Criteria) this;
        }

        public Criteria andTagNumIsNull() {
            addCriterion("tag_num is null");
            return (Criteria) this;
        }

        public Criteria andTagNumIsNotNull() {
            addCriterion("tag_num is not null");
            return (Criteria) this;
        }

        public Criteria andTagNumEqualTo(Integer value) {
            addCriterion("tag_num =", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotEqualTo(Integer value) {
            addCriterion("tag_num <>", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumGreaterThan(Integer value) {
            addCriterion("tag_num >", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_num >=", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumLessThan(Integer value) {
            addCriterion("tag_num <", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumLessThanOrEqualTo(Integer value) {
            addCriterion("tag_num <=", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumIn(List<Integer> values) {
            addCriterion("tag_num in", values, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotIn(List<Integer> values) {
            addCriterion("tag_num not in", values, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumBetween(Integer value1, Integer value2) {
            addCriterion("tag_num between", value1, value2, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_num not between", value1, value2, "tagNum");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIsNull() {
            addCriterion("visit_size is null");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIsNotNull() {
            addCriterion("visit_size is not null");
            return (Criteria) this;
        }

        public Criteria andVisitSizeEqualTo(Long value) {
            addCriterion("visit_size =", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotEqualTo(Long value) {
            addCriterion("visit_size <>", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeGreaterThan(Long value) {
            addCriterion("visit_size >", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("visit_size >=", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeLessThan(Long value) {
            addCriterion("visit_size <", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeLessThanOrEqualTo(Long value) {
            addCriterion("visit_size <=", value, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeIn(List<Long> values) {
            addCriterion("visit_size in", values, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotIn(List<Long> values) {
            addCriterion("visit_size not in", values, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeBetween(Long value1, Long value2) {
            addCriterion("visit_size between", value1, value2, "visitSize");
            return (Criteria) this;
        }

        public Criteria andVisitSizeNotBetween(Long value1, Long value2) {
            addCriterion("visit_size not between", value1, value2, "visitSize");
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