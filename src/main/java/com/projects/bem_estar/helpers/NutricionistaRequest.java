package com.projects.bem_estar.helpers;

public class NutricionistaRequest {
    private String comando;
    private Option options;

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public Option getOptions() {
        return options;
    }

    public void setOptions(Option options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "{" +
                "\"comando\": \"" + comando + "\"," +
                "\"options\": " + options +
                "}";
    }

}
