package api.endpoints;

public enum UserEndpoints {
    GENERATE_TOKEN("/Account/v1/GenerateToken"),
    GET_USER("/Account/v1/User/");

    private final String endpoints;

    UserEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoints() {
        return endpoints;
    }
}
