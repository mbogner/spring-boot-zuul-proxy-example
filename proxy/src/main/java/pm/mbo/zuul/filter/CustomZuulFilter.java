package pm.mbo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		log.info("add header test");
		final RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("Test", "TestSample");
		return null; // ignored
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * pre   filters are executed before the request is routed,
	 * route filters can handle the actual routing of the request,
	 * post  filters are executed after the request has been routed, and
	 * error filters execute if an error occurs in the course of handling the request.
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER + 110;
	}

}