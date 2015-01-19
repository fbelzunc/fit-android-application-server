package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 *
 * @author Roy Clarkson
 */
@Controller
@RequestMapping("/*")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("Spring Android Basic Auth");
        return "home";
    }

    @RequestMapping(value = "/getmessage", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Message getMessage() {
        logger.info("Accessing protected resource");
        return new Message(100, "Congratulations!", "You have accessed a Basic Auth protected resource.");
    }

}
