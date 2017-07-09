package de.bonprix.sessionservice;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopSession {
	
	String id;
	Map<String, String> internal = new HashMap<>();
	
	
	public ShopSession() {};
	public ShopSession(String id) {
		this.id = id;
	}

	
	//1.tomcat-session-attribut:
	//public static final String XPLOSION_NEWSLETTER_FLAG = "xplosionNewsletterFlag";
//	String xplosionNewsletterFlag;
	
	//2.cookie
//	String uid;
	
	//3.wkorb-wert
//	String referrer;
//
//	public Long getLocalUniqueKey() {
//		return localUniqueKey;
//	}

	

	public void setId(String id) {
		this.id = id;
	}
//
//	public String getXplosionNewsletterFlag() {
//		return xplosionNewsletterFlag;
//	}
//
//	public void setXplosionNewsletterFlag(String xplosionNewsletterFlag) {
//		this.xplosionNewsletterFlag = xplosionNewsletterFlag;
//	}
//
//	public String getUid() {
//		return uid;
//	}
//
//	public void setUid(String uid) {
//		this.uid = uid;
//	}
//
//	public String getReferrer() {
//		return referrer;
//	}
//
//	public void setReferrer(String referrer) {
//		this.referrer = referrer;
//	}
	
	
	public void set(String key, String value) {
		internal.put(key, value);
	}
	
	public String get(String key) {
		return internal.get(key);
	}
	public String getId() {
		return id;
	}
	public Map<String, String> getInternal() {
		return internal;
	}
	
	
	

}
