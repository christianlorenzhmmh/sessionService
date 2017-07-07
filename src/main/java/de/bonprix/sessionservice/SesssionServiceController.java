package de.bonprix.sessionservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.
@RequestMapping("/shopsession")
public class SesssionServiceController {
	private static final Log log = LogFactory.getLog(SesssionServiceController.class);

	@Value("${server.port}")
	private int port = 8080;

	Map<String, ShopSession> shopSessions = new HashMap<>();


	//	@RequestMapping(value="/{prettyUrl:[a-z0-9\\-]+}/")
	//    public ModelAndView getChannel(@PathVariable("prettyUrl") String prettyUrl,


	@RequestMapping(value="/{sessionkey:[a-z0-9\\-]+}/" , method = RequestMethod.PUT)
	public HttpStatus setSessionValue(@PathVariable("sessionkey") String sessionkey,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="value", required=true) String newValue) {

		ShopSession shopSession = shopSessions.get(sessionkey);
		if (shopSession == null) {
//			return HttpStatus.NOT_FOUND;
			shopSession = new ShopSession(sessionkey);
			shopSessions.put(sessionkey, shopSession);
		}
		shopSession.set(name, newValue);
 		return HttpStatus.OK;
	}
	
	


	//	@RequestMapping(value="/{sessionkey:[0-9\\-]+}/" , method = RequestMethod.GET)
	//	public String getSessionValue(@PathVariable("sessionkey") String sessionkey) {
	//		ShopSession session = new ShopSession();
	//		return "start/" + subcall1Result + ", " + subcall2Result.getBody() + ", " + subcall3WithCustomTraceResult;
	//	}


}