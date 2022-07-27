package com.pandy.json.parsejson;

import java.io.Serializable;

public class Model implements Serializable {

    private String C2Server;

    private String URL;

    public String getC2Server() {
        return C2Server;
    }

    public void setC2Server(String c2Server) {
        C2Server = c2Server;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Model{" +
                "C2Server='" + C2Server + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
