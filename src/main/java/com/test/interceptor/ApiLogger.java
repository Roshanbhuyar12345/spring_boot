package com.test.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.test.entity.ApiLoggerEntity;
import com.test.entity.LoggerEntity;
import com.test.exception.ErrorDetail;
import com.test.service.ApiLoggerService;
import com.test.service.LoggerEntityService;

@Component
public class ApiLogger implements HandlerInterceptor {

	public ApiLogger() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ApiLoggerService apiLoggerService;

	@Autowired
	private LoggerEntityService loggerEntityService;

	Gson gson = new Gson();

	public boolean preHandler(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String[] arr = request.getRequestURI().split("/");
		String getparam = arr[arr.length - 1];
		String getparam2 = arr[arr.length - 2];
		ArrayList<String> skipUrls = new ArrayList<String>(
				Arrays.asList("/auth/login", "/auth/logout", "/auth/register" + getparam + "/" + getparam2));

		if (!skipUrls.contains(request.getRequestURI())) {

			final String requestTokenHeader = request.getHeader("Authorization").split(" ")[1];
			LoggerEntity logDetail = this.loggerEntityService.createLogger(requestTokenHeader);

			if (logDetail == null) {

				ErrorDetail error = new ErrorDetail(new Date(), "You are not login", "NotLoginUsr", true);

				String employeeJsonString = this.gson.toJson(error);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(employeeJsonString);

				return false;
			} else {
				ApiLoggerEntity apiLoggerEntity = new ApiLoggerEntity();
				apiLoggerEntity.setUserToken(requestTokenHeader);
				apiLoggerEntity.setIpAdress(request.getRemoteAddr());
				apiLoggerEntity.setUrl(request.getRequestURI());
				apiLoggerEntity.setHost(request.getRemoteHost());
				apiLoggerEntity.setBody(request instanceof StandardMultipartHttpServletRequest ? null
						: request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

				this.apiLoggerService.createApiLog(apiLoggerEntity);

				return true;

			}

		} else {
			return true;
		}

	}

}
