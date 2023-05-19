class Config {

}

class DevelopmentConfig {
    public apiURL = "http://localhost:3030/api/";
    public songURL = this.apiURL + "song/"
    public packURL = this.apiURL + "pack/"
}

class ProductionConfig {
    public apiURL = "https://www.something.com/api/";
    public songURL = this.apiURL + "song/"
    public packURL = this.apiURL + "pack/"
}

const config = process.env.NODE_ENV === "development" ? new DevelopmentConfig() : new ProductionConfig();

export default config;