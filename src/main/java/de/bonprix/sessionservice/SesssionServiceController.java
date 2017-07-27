package de.bonprix.sessionservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.
@RequestMapping("/shopsessions")
public class SesssionServiceController {
	private static final Log log = LogFactory.getLog(SesssionServiceController.class);

	@Value("${server.port}")
	private int port = 8080;
	Map<String, ShopSession> shopSessions = new HashMap<>();


	//	@RequestMapping(value="/{prettyUrl:[a-z0-9\\-]+}/")
	//    public ModelAndView getChannel(@PathVariable("prettyUrl") String prettyUrl,

//ggf. garnicht notwendig jedes property update zu schicken weil am ende des requests die komplette session gesaved wird
//	@RequestMapping(value="/{sessionkey:[a-z0-9\\-]+}" , 
//			method = RequestMethod.PUT)
//	public HttpStatus setSessionValue(@PathVariable("sessionkey") String sessionkey,
//			@RequestParam(value="name", required=true) String name,
//			@RequestParam(value="value", required=true) String newValue) {
//
//		ShopSession shopSession = shopSessions.get(sessionkey);
//		if (shopSession == null) {
//						return HttpStatus.NOT_FOUND;
////			shopSession = new ShopSession(sessionkey);
////			shopSessions.put(sessionkey, shopSession);
//		}
//		shopSession.set(name, newValue);
//		return HttpStatus.OK;
//	}

	
	@RequestMapping(value="/" , 
			method = RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus saveSession(
			@RequestBody ShopSession updatedShopSession) {

		shopSessions.put(updatedShopSession.getId(), updatedShopSession);
		return HttpStatus.OK;
	}



	@RequestMapping(value="/{id:[a-z0-9\\-]+}" , 
			method = RequestMethod.GET, 
			produces =  MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody ResponseEntity<ShopSession> getSession(@PathVariable("id") String id) {
		ShopSession shopSession = shopSessions.get(id);
		if (shopSession == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(shopSession);
	}
	
	
//	@RequestMapping(value="/{decodedWebshopSessionId:[0-9\\-]+}" , 
//			method = RequestMethod.GET, 
//			produces =  MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody 
//	public ResponseEntity<ShopSession> getSession(@PathVariable("decodedWebshopSessionId") String decodedWebshopSessionId) {
//		Iterator<ShopSession> it = shopSessions.values().iterator();
//		while (it.hasNext()) {
//			ShopSession ss = it.next();
//			if (decodedWebshopSessionId.equals(ss.getDecodedWebshopSessionId())) {
//				return ResponseEntity.ok(ss);
//			}
//		}
////		ShopSession shopSession = shopSessions.get(decodedWebshopSessionId);
////		if (shopSession == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
////		}
//	}
	
	
	//webshop muss sessionkey liefern (aber der sessionService erstellt seine unique "DB-ID" selber! sessionkey ist dann ein property der ShopSession)
	//sessionKey wird zumindest erstmal die wkorbid sein
//	@RequestMapping(value="/{sessionkey:[a-z0-9\\-]+}", 
	@RequestMapping(value="/", 
			method = RequestMethod.POST, 
			produces =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<ShopSession> createSession() {
//	public ResponseEntity<ShopSession> createSession(@PathVariable("sessionkey") String sessionkey) {
//	public HttpStatus createSession(@PathVariable("sessionkey") String sessionkey) {
		String sessionId = createUniqueSessionId();
		ShopSession shopSession = new ShopSession(sessionId);
		shopSessions.put(sessionId, shopSession);
		return ResponseEntity.ok(shopSession);
		//			return HttpStatus.CREATED;
		}



	private String createUniqueSessionId() {
		UUID id = UUID.randomUUID();
		return "" + id.toString();
	}


}