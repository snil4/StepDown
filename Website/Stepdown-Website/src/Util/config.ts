class Config {

}

class DevelopmentConfig {
    public baseURL = "http://localhost:3030/";
    public apiURL = this.baseURL+ "api/";
    public songURL = this.apiURL + "song/"
    public packURL = this.apiURL + "pack/"
    public imageURL = this.baseURL + "image/";
}

class ProductionConfig {
    public baseURL = "https://www.something.com/";
    public apiURL = this.baseURL+ "api/";
    public songURL = this.apiURL + "song/"
    public packURL = this.apiURL + "pack/"
    public imageURL = this.baseURL + "image/";
}

const config = process.env.NODE_ENV === "development" ? new DevelopmentConfig() : new ProductionConfig();

export default config;