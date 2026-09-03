package web.tables.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusArguments {
    private final Logger logger = LoggerFactory.getLogger(ManagerSelenium.class);

    public <T>void status_values(T arg, T arg2, T arg3) {
        if(arg == null || arg2 == null || arg3 == null)
            this.logger.error("Invalid arguments - [3]");
    }
    public <T>void status_values(T arg, T arg2) {
        if(arg == null || arg2 == null)
            this.logger.error("Invalid arguments - [2]");
    }
    public <T>void status_values(T arg, String type) {
        if(arg == null)
            this.logger.error("Invalid arguments - [{}]", type);
    }
    public <R>void successfully(R arg) {
        if(arg != null)
            this.logger.info("Driver quited");
    }
    public <R>void successfully(R arg, R arg2,  R arg3) {
        if(arg != null && arg2 != null && arg3 != null) {
            this.logger.info("Objects initialized: {}%", 100);
        } else {
            this.logger.error("Invalid arguments - [objects]");
        }
    }
}
