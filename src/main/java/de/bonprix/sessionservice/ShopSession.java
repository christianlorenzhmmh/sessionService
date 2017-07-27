package de.bonprix.sessionservice;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopSession {

	String id;//just for internal persistence 
	private String decodedWebshopSessionId;
	//	String sessionkey; //the wkorbid
	//	Map<String, String> internal = new HashMap<>();


    private long creationTime = System.currentTimeMillis();
    
    private long lastAccessedTime = creationTime;
    
    
    
	public ShopSession() {};
	public ShopSession(String id) {
		this.id = id;
	}


	//1.tomcat-session-attribut:
	//public static final String XPLOSION_NEWSLETTER_FLAG = "xplosionNewsletterFlag";
	String xplosionNewsletterFlag;

	//2.cookie
	String uid;

	//3.wkorb-wert
	String useragent;
	//
	//	public Long getLocalUniqueKey() {
	//		return localUniqueKey;
	//	}



	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}



	//	public String getSessionkey() {
	//		return sessionkey;
	//	}
	//	public void setSessionkey(String sessionkey) {
	//		this.sessionkey = sessionkey;
	//	}

	public String getDecodedWebshopSessionId() {
		return decodedWebshopSessionId;
	}
	public void setDecodedWebshopSessionId(String decodedWebshopSessionId) {
		this.decodedWebshopSessionId = decodedWebshopSessionId;
	}



	public String getXplosionNewsletterFlag() {
		return xplosionNewsletterFlag;
	}

	public void setXplosionNewsletterFlag(String xplosionNewsletterFlag) {
		this.xplosionNewsletterFlag = xplosionNewsletterFlag;
	}


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getUseragent() {
		return useragent;
	}
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
	
	
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	
	
	public long getLastAccessedTime() {
		return lastAccessedTime;
	}
	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}


	//	
	//	public void set(String key, String value) {
	//		internal.put(key, value);
	//	}
	//	
	//	public String get(String key) {
	//		return internal.get(key);
	//	}

	//	public Map<String, String> getInternal() {
	//		return internal;
	//	}
	//	



}
