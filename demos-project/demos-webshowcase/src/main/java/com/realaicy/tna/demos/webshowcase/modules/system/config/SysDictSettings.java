package com.realaicy.tna.demos.webshowcase.modules.system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Realaicy on 2015/6/1.
 * XXX
 */
@Component
@ConfigurationProperties(prefix = "sysdict")
public class SysDictSettings {

    /**
     * Getter for property 'fetch'.
     *
     * @return Value for property 'fetch'.
     */
    public Fetch getFetch() {
        return fetch;
    }

    /**
     * Setter for property 'fetch'.
     *
     * @param fetch Value to set for property 'fetch'.
     */
    public void setFetch(Fetch fetch) {
        this.fetch = fetch;
    }

    /**
     * The type Fetch.
     */
    private Fetch fetch = new Fetch();

    /**
     * The type Fetch.
     */
    public static class Fetch {
        /**
         * Getter for property 'url'.
         *
         * @return Value for property 'url'.
         */
        public String getUrl() {
            return url;
        }

        /**
         * Setter for property 'url'.
         *
         * @param url Value to set for property 'url'.
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * The   Fetch url.
         */
        private String url;

    }

    /**
     * Getter for property 'debugrequest'.
     *
     * @return Value for property 'debugrequest'.
     */
    public String getDebugrequest() {
        return debugrequest;
    }

    /**
     * Setter for property 'debugrequest'.
     *
     * @param debugrequest Value to set for property 'debugrequest'.
     */
    public void setDebugrequest(String debugrequest) {
        this.debugrequest = debugrequest;
    }

    /**
     * {@inheritDoc}
     */
    private String debugrequest;
    /**
     * {@inheritDoc}
     */
    private String tempTest;


    /**
     * Getter for property 'tempTest'.
     *
     * @return Value for property 'tempTest'.
     */
    public String getTempTest() {
        return tempTest;
    }

    /**
     * Setter for property 'tempTest'.
     *
     * @param tempTest Value to set for property 'tempTest'.
     */
    public void setTempTest(String tempTest) {
        this.tempTest = tempTest;
    }
}
