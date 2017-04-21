package controllers;

import play.mvc.Controller;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import views.html.index;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	int ticketAvailable = 1000;
        //return ok(index.render("Your new application is ready."));
    	response().setHeader(CACHE_CONTROL, "max-age=3600");
    	session("connected", "user@gmail.com");
    	response().setHeader(ETAG, "ABC");	
    	response().setCookie(Cookie.builder("theme", "blue").build());
    	return ok(index.render("Your new application is ready.",ticketAvailable));
    }

}
