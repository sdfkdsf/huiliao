package com.coinMall.common.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HTTP服务类
 */
@Service
public class HttpService {
	private static Logger logger = Logger.getLogger(HttpService.class);
	@Autowired
    private CloseableHttpClient httpClient;
	
	@Autowired
    private RequestConfig requestConfig;
	
	/**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url) throws Exception {
        try {
        	HttpGet httpGet = new HttpGet(url);
        	httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = this.httpClient.execute(httpGet);// 发起请求
			return getResponse(response);
		} catch (Exception e) {
			logger.error("HttpService服务doGet异常，url="+url, e);
			throw e;
		}
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
		URIBuilder uriBuilder = new URIBuilder(url);
		if (map != null) {
		    for (Map.Entry<String, Object> entry : map.entrySet()) {// 遍历map,拼接请求参数
		        uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
		    }
		}
		return this.doGet(uriBuilder.build().toString());// 调用不带参数的get请求
    }

    /**
     * 带参数的post请求
     * @param url 
     * @param map 
     * @return
     * @throws Exception
     */
    public String doPost(String url, Map<String, Object> map) throws Exception {
        try {
			HttpPost httpPost = new HttpPost(url);	// 声明httpPost请求
			httpPost.setConfig(requestConfig);	// 加入配置信息
			if (map != null) { 	// 判断map是否为空，不为空则进行遍历，封装from表单对象
			    List<NameValuePair> list = new ArrayList<NameValuePair>();
			    for (Map.Entry<String, Object> entry : map.entrySet()) {
			        list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
			    }
			    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, CHARSET);// 构造from表单对象
			    httpPost.setEntity(urlEncodedFormEntity);// 把表单放到post里
			}
			CloseableHttpResponse response = this.httpClient.execute(httpPost);// 发起请求
			return getResponse(response);
		} catch (Exception e) {
			logger.error("HttpService服务doPost异常，url="+url, e);
			throw e;
		}
    }
    
    /**
     * 参数为JSON格式的POST请求
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    public String doPostJson(String url, String json) throws Exception {
        try {
			HttpPost httpPost = new HttpPost(url);	// 声明httpPost请求
			httpPost.setConfig(requestConfig);	// 加入配置信息
			httpPost.addHeader(CONTENT_TYPE, APPLICATION_JSON);
			httpPost.setEntity(new StringEntity(json,CHARSET));
			CloseableHttpResponse response = this.httpClient.execute(httpPost);// 发起请求
			return getResponse(response);
		} catch (Exception e) {
			logger.error("HttpService服务doPostJson异常，url="+url, e);
			throw e;
		}
    }

    /**
     * 不带参数post请求
     * @param url
     * @return
     * @throws Exception
     */
    public String doPost(String url) throws Exception {
		return this.doPost(url, null);
    }
    
    private String getResponse(CloseableHttpResponse response) throws ParseException, IOException {
    	String result = null;
    	try {
        	if(response.getStatusLine().getStatusCode()==200)
        		result = EntityUtils.toString(response.getEntity(), CHARSET);
        	logger.debug("HTTP响应"+result);
		} finally {
			if(response != null)response.getEntity().getContent().close();
		}
        return result;
    }
    private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";
	private static final String CHARSET = "UTF-8";
}
