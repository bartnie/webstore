/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.interceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {
	private final ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorInterceptor.class);

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
					throws Exception {
		final String id = handler.toString();
		final StopWatch stopWatch = new StopWatch(id);
		stopWatch.start(id);
		stopWatchLocal.set(stopWatch);
		LOGGER.info(String.format("Processing request for URL: %s", getURLPath(request)));
		LOGGER.info(String.format("Processing request started at: %s", getCurrentTime()));
		return true;
	}

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
					@Nullable final ModelAndView modelAndView) throws Exception {
		LOGGER.info(String.format("Processing request finished at: %s", getCurrentTime()));
	}

	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
					final Object handler, @Nullable final Exception ex) throws Exception {
		final StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		LOGGER.info(String.format("Summaric time ofprocessing request: %s ms", stopWatch.getTotalTimeSeconds()));
		stopWatchLocal.set(null);
		LOGGER.info("================================================================");
	}

	private String getURLPath(final HttpServletRequest request) {
		final String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath.concat(queryString);
	}

	private String getCurrentTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}

}
