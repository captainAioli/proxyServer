package com.ecommerce.proxyserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Filter;
import java.util.logging.Logger;

public class TrackingFilter extends ZuulFilter {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    private FilterUtil filterUtil;

    @Override
    public String filterType() {
        return FilterUtil.FILTER_TYPE_PRE;
    }

    @Override
    public int filterOrder() {
        return FilterUtil.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return FilterUtil.SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        filterUtil.setTransactionId();
        logger.info("création d'ID de la requête"+filterUtil.getTransactionId());
        return null;
    }
}
